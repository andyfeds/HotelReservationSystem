package HotelReservationSystem.controller;

import java.io.IOException;
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
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import HotelReservationSystem.model.CheckOut;
import HotelReservationSystem.model.Guest;
import HotelReservationSystem.model.Room;
import HotelReservationSystem.model.RoomTypes;


@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BillServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  try {

			  HttpSession sessionObj=null;
			  sessionObj=request.getSession(true);
				SessionFactory sessionFactory=configureSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				int stayDuration,restaurantAmount=5000, totalAmount=0, hotelAmount=0;
				String guestName;
				System.out.println(sessionObj.getAttribute("checkoutid"));
				
				try {
						
						Query query = session.createQuery("from CheckOut where CheckOutId= :CheckOutId");
						query.setParameter("CheckOutId",sessionObj.getAttribute("checkoutid"));
						
						@SuppressWarnings("unchecked")
						List<CheckOut> checkOutList=query.list();
						
						stayDuration=checkOutList.get(0).getDaysStayed();
						
						System.out.println(stayDuration);
						
						
						
						Query query1 = session.createQuery("from Room where RoomNo= :RoomNo");
						query1.setParameter("RoomNo",checkOutList.get(0).getRoomNo());
						@SuppressWarnings("unchecked")
						List<Room> roomList=query1.list();	
						
						
						 
						 Query query2 = session.createQuery("from RoomTypes where roomtypeid= :roomtypeid");
							query2.setParameter("roomtypeid",roomList.get(0).getRoomtypeid());
							@SuppressWarnings("unchecked")
							List<RoomTypes> roomTypeList=query2.list();	
						
							 hotelAmount=stayDuration*roomTypeList.get(0).getRoomprice();
							totalAmount=hotelAmount+restaurantAmount;
							
							Query query3 = session.createQuery("from Guest where guestId= :guestId");
							query3.setParameter("guestId",checkOutList.get(0).getGuestid());
							@SuppressWarnings("unchecked")
							List<Guest> guestList=query3.list();	
							guestName=guestList.get(0).getGfname()+" "+guestList.get(0).getGlname();
							
							request.setAttribute("guestName",guestName);
							request.setAttribute("restaurantAmount",restaurantAmount);
							request.setAttribute("stayDuration",stayDuration);
							request.setAttribute("hotelAmount",hotelAmount);
							request.setAttribute("totalAmount",totalAmount);
							
							
							RequestDispatcher dispatcher = request.getRequestDispatcher("finalBill.jsp");

							  if (dispatcher != null){

							  dispatcher.forward(request, response);

							  } 
				
				} catch (Exception e) {
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
