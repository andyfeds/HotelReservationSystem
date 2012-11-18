package HotelReservationSystem.controller;

import java.io.IOException;
import java.util.Calendar;
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

import HotelReservationSystem.model.Cancel;
import HotelReservationSystem.model.Reservation;
import HotelReservationSystem.model.RoomTypes;

@WebServlet("/cancelReservationServlet")
public class cancelReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public cancelReservationServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {

			
			SessionFactory sessionFactory=configureSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tran=null;
			tran=session.beginTransaction();
			float amt=0;
			try {
				Calendar cDate=new GregorianCalendar();
				Calendar cancelDate=new GregorianCalendar();
				cDate.set(2012,11,16);
				cancelDate=cDate;
				int day,month,year;
				Calendar aDate,dDate;
				int guestId, reserveId,pnr;
				String roomTypeId;
				
				
				Query query = session.createQuery("from Reservation where pnr=:pnr");
				query.setParameter("pnr",Integer.parseInt(request.getParameter("pnr")));
				@SuppressWarnings("unchecked")
				List<Reservation> list=query.list();
				
				System.out.println(list.get(0).getPnr());
				reserveId=list.get(0).getReserveId();
				roomTypeId=list.get(0).getRoomtypeid();
				aDate=list.get(0).getArrivatDate();
				dDate=list.get(0).getDepartureDate();
				guestId=list.get(0).getGuestId();
				pnr=list.get(0).getPnr();
				
				
				
				day=cDate.get(Calendar.DAY_OF_MONTH);
				month=cDate.get(Calendar.MONTH);
				year=cDate.get(Calendar.YEAR);
				
				cDate.set(year, month-1, day);
				
				
				if(cDate.after(aDate))
				{
					request.setAttribute("msg","Sorry Unable To Cancel!!!! Date Has Crossed your Arrival Date!!!");
					 RequestDispatcher dispatcher = request.getRequestDispatcher("cancelReservationStatus.jsp");

					  if (dispatcher != null){

					  dispatcher.forward(request, response);

					  } 
				}
				
				
				else
				{
					cDate.set(year, month-1, day+5);
					
					if(cDate.after(aDate))
						{	
						
						
						Cancel cancelRes=new Cancel();
						cancelRes.setCancelDate(cancelDate);
						cancelRes.setReserveId(reserveId);
						cancelRes.setRoomTypeId(roomTypeId);
						cancelRes.setArrivalDate(aDate);
						cancelRes.setDepartureDate(dDate);
						cancelRes.setGuestId(guestId);
						cancelRes.setPnr(pnr);
						session.save(cancelRes);
					    
						
					    Query query2 = session.createQuery("delete from Reservation where pnr= :pnr");
						query2.setParameter("pnr", Integer.parseInt(request.getParameter("pnr")));
						query2.executeUpdate();
						
						int bookedDuration=daysBetween(aDate,dDate);
						 try
						 {
							Query query1 = session.createQuery("from RoomTypes where roomtypeid=:roomtypeid");
							query1.setParameter("roomtypeid",roomTypeId);
							@SuppressWarnings("unchecked")
							List<RoomTypes> roomlist=query1.list();
							int roomPrice=roomlist.get(0).getRoomprice();
							
							amt=roomPrice*bookedDuration;
							amt=(float) (amt*0.30);
						 }
						 catch(Exception e)
						 {
							 e.printStackTrace();
						 }
							tran.commit();
							
							
							
							 request.setAttribute("msg","Reservation Cancelled Successfully!!! <br/>30% of total amount will be charged on your credit card.<br/> Rs. "+amt+ " Deducted" );
							 
						 
						 RequestDispatcher dispatcher = request.getRequestDispatcher("cancelReservationStatus.jsp");

						 if (dispatcher != null){

						  dispatcher.forward(request, response);

						  } 
						
						
						
						}
				
					else
					{
						
					
						Cancel cancelRes=new Cancel();
						cancelRes.setCancelDate(cancelDate);
						cancelRes.setReserveId(reserveId);
						cancelRes.setRoomTypeId(roomTypeId);
						cancelRes.setArrivalDate(aDate);
						cancelRes.setDepartureDate(dDate);
						cancelRes.setGuestId(guestId);
						cancelRes.setPnr(pnr);
						session.save(cancelRes);
					    
					    request.setAttribute("msg","Reservation Cancelled Successfully!!!");
						Query query2 = session.createQuery("delete from Reservation where pnr= :pnr");
						query2.setParameter("pnr", Integer.parseInt(request.getParameter("pnr")));
						query2.executeUpdate();
						
						tran.commit();
						 RequestDispatcher dispatcher = request.getRequestDispatcher("cancelReservationStatus.jsp");

						  if (dispatcher != null){

						  dispatcher.forward(request, response);

						  } 
					}
				
				}
				
			}
			
			catch (Exception e) {
				session.getTransaction().rollback();
				System.out.println("Error");
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
		  while (date.before(endDate)) 
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
