package HotelReservationSystem.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import HotelReservationSystem.model.CheckIn;
import HotelReservationSystem.model.Reservation;


@WebServlet("/extendReservationServlet")
public class extendReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public extendReservationServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	try 
    	{

			
			SessionFactory sessionFactory=configureSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tran=null;
			tran=session.beginTransaction();
			boolean flag=false;

			try 
			{
				Calendar newDate=new GregorianCalendar();
				int numDays,stayDays;
				
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dodep"));
				newDate.setTime(date1);
				
				Query query = session.createQuery("from Reservation where pnr= :pnr");
				query.setParameter("pnr",Integer.parseInt(request.getParameter("pnr")));
				
				
				@SuppressWarnings("unchecked")
				List<Reservation> roomTypeList=query.list();
			
				
				String roomTypeId=roomTypeList.get(0).getRoomtypeid();
				int reservationId=roomTypeList.get(0).getReserveId();
				Query query1 = session.createQuery("from Reservation where roomtypeid= :roomtypeid");
				query1.setParameter("roomtypeid",roomTypeId);
				@SuppressWarnings("unchecked")
				List<Reservation> reservationList=query1.list();
				
				
			for (int i = 0; i < reservationList.size(); i++) {
				
				
				if((newDate.before(reservationList.get(i).getArrivatDate())))
				{
					flag=true;
				}
				else
				{
					flag=false;
					break;
				}	
					
					if(flag)
					{
					
					Query query2 = session.createQuery("from CheckIn where ReserveId= :reserveid");
					query2.setParameter("reserveid",reservationId);
					
					@SuppressWarnings("unchecked")
					List<CheckIn> checkInList=query2.list();
					
					
					stayDays=checkInList.get(0).getStayDays();
					numDays=daysBetween(roomTypeList.get(0).getDepartureDate(),newDate);
					stayDays=stayDays+numDays;
					
									
					CheckIn checkin = (CheckIn)checkInList.get(0);
					checkin.setStayDays(stayDays);
					session.update(checkin);
					
					
					tran.commit();
					request.setAttribute("msg","Number of Stay Days has been Increased Successfully");
					}					
					else
					{
					request.setAttribute("msg","Cannot Increase Number of Stay days due to another Reservation..");
					
					
					}
			}
				
			RequestDispatcher dispatcher = request.getRequestDispatcher("cancelReservationStatus.jsp");

				  if (dispatcher != null){

				  dispatcher.forward(request, response);

				  } 
			
			
			}
			
			catch (Exception e) {
				session.getTransaction().rollback();
				System.out.println("Error");
				request.setAttribute("msg","Unexpected Error..Cannot Extend");
				RequestDispatcher dispatcher = request.getRequestDispatcher("cancelReservationStatus.jsp");

				  if (dispatcher != null){

				  dispatcher.forward(request, response);

				  } 
			}
			finally{
				session.close();
			}
			
	
    	}


catch(Exception e){

	  System.out.println("Exception is ;"+e);

	  }
    	
    }
    
    
    private static int daysBetween(Calendar startDate, Calendar endDate)
	{  
    	  Calendar date = (Calendar) startDate.clone();  
		  int daysBetween = 0;  
		  while(date.before(endDate)) 
		  {  
		    date.add(Calendar.DAY_OF_MONTH, 1);  
		    daysBetween++;  
		  }  
		 
		  return daysBetween;  
		}
    
    private static SessionFactory configureSessionFactory()
	{
		SessionFactory sessionFactory;
		ServiceRegistry serviceRegistry;
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
}
