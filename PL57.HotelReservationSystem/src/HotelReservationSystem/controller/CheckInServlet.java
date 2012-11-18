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

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import HotelReservationSystem.model.CheckIn;
import HotelReservationSystem.model.Reservation;
import HotelReservationSystem.model.Room;


@WebServlet("/CheckInServlet")
public class CheckInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String page = "CheckInSuccess.jsp";
	String InvalidPage = "InvalidReserve.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		;
			
			
			
			try {
			
				  Transaction tran = null;		
				  SessionFactory sessionFactory=configureSessionFactory();
				  Session session=sessionFactory.openSession();
				  tran=session.beginTransaction();
				
				try {
					
					String temp = request.getParameter("Pnr");	
									
					Query query = session.createQuery("from Reservation where pnr = '"+ temp +"'");
					
					
					System.out.println("query size = "+query.list().size());
					
					if(!query.list().isEmpty()){
						
						CheckIn checkIn = new CheckIn();
						@SuppressWarnings("unchecked")
						List<Reservation> reserveList = query.list();
						
						
						try {
													
							checkIn.setReserveId(reserveList.get(0).getReserveId());
							checkIn.setCheckInDate(reserveList.get(0).getArrivatDate());
							GregorianCalendar depDate = reserveList.get(0).getDepartureDate();
							GregorianCalendar arriveDate = reserveList.get(0).getArrivatDate();							
							int daysBetween = daysBetween(arriveDate, depDate);							
							checkIn.setStayDays(daysBetween);							
							GregorianCalendar cal = new GregorianCalendar();
							Date date = cal.getTime();
							DateFormat df2 = DateFormat.getTimeInstance(DateFormat.SHORT);
							String time = df2.format(date);
							
							checkIn.setCheckInTime(time);							
							String roomTId = reserveList.get(0).getRoomtypeid();							
							Query RoomTquery = session.createQuery("from Room where roomtypeid = '" + roomTId +"' and status = 'available' ");																					
							@SuppressWarnings("unchecked")
							List<Room> roomList = RoomTquery.list();
							
							checkIn.setRoomNo(roomList.get(0).getRoomNo());
							
							String roomNo = Integer.toString(roomList.get(0).getRoomNo());
							
							Query updatequery = session.createQuery("update Room set Status = 'occupied' where RoomNo = '"+ roomNo +"' ");							
							
							updatequery.executeUpdate();
							
							session.save(checkIn);
							tran.commit();
							
							RequestDispatcher dispatcher = request.getRequestDispatcher(page);

							  if (dispatcher != null){

							  dispatcher.forward(request, response);

							  } 
							
							
						} catch (Exception e) {
						
							session.getTransaction().rollback();
							System.err.println("error in innermost try catch is : " + e);
						}
						
					}
					else
					{
						RequestDispatcher dispatcher = request.getRequestDispatcher(InvalidPage);

						  if (dispatcher != null){

						  dispatcher.forward(request, response);

						  } 

						
					}
					
					
					
				} catch (Exception e) {
					
					System.err.println("error in 1st inner try catch is : " + e);
				}
				
			} catch (Exception e) {
				System.err.println("error in outermost try catch is : " + e);
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
