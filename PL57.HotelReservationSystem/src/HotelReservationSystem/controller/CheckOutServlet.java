package HotelReservationSystem.controller;

import java.io.IOException;
import java.text.DateFormat;
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
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import HotelReservationSystem.model.CheckIn;
import HotelReservationSystem.model.CheckOut;
import HotelReservationSystem.model.Reservation;

@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String page = "CheckoutSuccess.jsp";
	String Wrongpage = "InvalidCheckout.jsp";
	
    public CheckOutServlet() {
        super();
     
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("CheckInId"));
		
		try {
			  HttpSession ses = request.getSession(true);
			  Transaction tran = null;		
			  SessionFactory sessionFactory=configureSessionFactory();
			  Session session=sessionFactory.openSession();
			  tran=session.beginTransaction();
			  
			try {	
					
					String checkInId = request.getParameter("CheckInId");
					Query query = session.createQuery("from CheckIn where CheckInId = '"+ checkInId +"'");
					
					System.out.println("list size "+query.list().size());
					
					if(!query.list().isEmpty()){
						
						System.out.println("list size One "+query.list().size());
						
						CheckOut checkOut = new CheckOut();
						List<CheckIn> checkInList = query.list();
						
						Query query1 = session.createQuery("from Reservation where ReserveId= :ReserveId");
						query1.setParameter("ReserveId",checkInList.get(0).getReserveId());
						
						@SuppressWarnings("unchecked")
						List<Reservation> reserveList = query1.list();

						
						try {
							
								checkOut.setReserveId(checkInList.get(0).getReserveId());
								checkOut.setRoomNo(checkInList.get(0).getRoomNo());
								checkOut.setGuestid(reserveList.get(0).getGuestId());
								checkOut.setPnr(reserveList.get(0).getPnr());
								
								Calendar checkOutdate = Calendar.getInstance();
								
								Date date = checkOutdate.getTime();
								DateFormat df2 = DateFormat.getDateInstance(DateFormat.LONG);
								String dt = df2.format(date);
								
								checkOut.setCheckOutDate(checkOutdate);
								
								DateFormat df3 = DateFormat.getTimeInstance(DateFormat.SHORT);
								String time = df3.format(date);
								
								checkOut.setCheckOutTime(time);
								checkOut.setCheckInId(Integer.parseInt(checkInId));
								
								int roomNo = checkInList.get(0).getRoomNo();
								
								Query updatequery = session.createQuery("update Room set Status = 'available' where RoomNo = '"+ roomNo +"' ");
								
								updatequery.executeUpdate();
								
								// Calculation of days stayed...
								
								GregorianCalendar checkinDate = checkInList.get(0).getCheckInDate();
								
								int daysStayed = daysBetween(checkinDate, checkOutdate);
								
								checkOut.setDaysStayed(daysStayed);
								
								
								session.save(checkOut);
								
								

								HttpSession sessionObj=null;
								sessionObj=request.getSession(true);
								sessionObj.setAttribute("checkoutid",checkOut.getCheckOutId());
								
								Reservation res=(Reservation)reserveList.get(0);								
								session.delete(res);
								
								tran.commit();
								
								RequestDispatcher dispatcher = request.getRequestDispatcher(page);

								  if (dispatcher != null)
								  {

								  dispatcher.forward(request, response);

								  } 
							
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						
						
					}
					else
					{
						RequestDispatcher dispatcher = request.getRequestDispatcher(Wrongpage);

						  if (dispatcher != null)
						  {

						  dispatcher.forward(request, response);

						  } 

					}
					
					
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
		private static SessionFactory configureSessionFactory(){
		SessionFactory sessionFactory;
		ServiceRegistry serviceRegistry;
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

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

}
