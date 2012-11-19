package HotelReservationSystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import HotelReservationSystem.model.Reservation;
import HotelReservationSystem.model.Room;
import HotelReservationSystem.model.RoomTypes;

/**
 * Servlet implementation class getReserveDetails
 */
@WebServlet("/getReserveDetails")
public class getReserveDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String page = "ReservationDetails.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getReserveDetails() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
				
				ArrayList<Reservation> dataList=new ArrayList<Reservation>();
				SessionFactory sessionFactory=configureSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
			
			 	try {
			 		
			 			Query query = session.createQuery("from Reservation");
			 			
			 			List<Reservation> list=query.list();					
						Iterator<Reservation> iterator=list.iterator();
			 			
						System.out.println("size List "+list.size());
						
						ArrayList<RoomTypes> roomTypeList = new ArrayList<RoomTypes>(); 
						
						while(iterator.hasNext())
						{
							String rId = iterator.next().getRoomtypeid();
							Reservation rvn = iterator.next();
							Query roomTypeQuery = session.createQuery("from RoomTypes where roomtypeid = '"+ rId +"'");
							List<RoomTypes> roomTypelist=roomTypeQuery.list();
							
							roomTypeList.add(roomTypelist.get(0));
							
							dataList.add(rvn);
							
							System.out.println("***********"+rvn.getPnr());
						}
						
						System.out.println("size "+dataList.size());
						request.setAttribute("reserveData",dataList);
						request.setAttribute("roomTypeData",roomTypeList);
						  
						RequestDispatcher dispatcher = request.getRequestDispatcher(page);

						if (dispatcher != null){

							dispatcher.forward(request, response);

						} 
			 		
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(e);
				}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
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
