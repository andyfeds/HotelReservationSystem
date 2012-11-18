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

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String page = "CheckoutSuccess.jsp";
	String Wrongpage = "InvalidCheckout.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
						List<Reservation> reserveList = query1.list();
						System.out.println("list size RES two "+query1.list().size());
						try {
							
								checkOut.setReserveId(checkInList.get(0).getReserveId());
								checkOut.setRoomNo(checkInList.get(0).getRoomNo());
								checkOut.setGuestid(reserveList.get(0).getGuestId());
								checkOut.setPnr(reserveList.get(0).getPnr());
								Calendar checkOutdate = Calendar.getInstance();
								
								Date date = checkOutdate.getTime();
								DateFormat df2 = DateFormat.getDateInstance(DateFormat.LONG);
								String dt = df2.format(date);
								
								//System.out.println("date "+dt);
								checkOut.setCheckOutDate(checkOutdate);
								
								DateFormat df3 = DateFormat.getTimeInstance(DateFormat.SHORT);
								String time = df3.format(date);
								
								checkOut.setCheckOutTime(time);
								checkOut.setCheckInId(Integer.parseInt(checkInId));
								
								int roomNo = checkInList.get(0).getRoomNo();
								
								Query updatequery = session.createQuery("update Room set Status = 'available' where RoomNo = '"+ roomNo +"' ");
								
								updatequery.executeUpdate();
								
								session.save(checkOut);
								
								
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
	
}
