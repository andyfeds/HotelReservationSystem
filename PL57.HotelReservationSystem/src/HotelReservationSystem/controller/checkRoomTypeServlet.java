package HotelReservationSystem.controller;

import helper.HotelConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

import HotelReservationSystem.model.RoomTypes;



@WebServlet("/checkRoomTypeServlet")
public class checkRoomTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page="CheckRoomType.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkRoomTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");

		
		  try {

				RoomTypes r=new RoomTypes();
				//r.setRoomtypeid(54);
				
				SessionFactory sessionFactory=configureSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				try {
						int noRooms;
						Query query = session.createQuery("from RoomTypes where roomtype= :room");
						query.setParameter("room",request.getParameter("roomtype"));
					
						List<RoomTypes> list= query.list();
						noRooms=Integer.parseInt(request.getParameter("roomsnum"));
						
				
					if(noRooms>list.get(0).getAvailRooms())
						response.getWriter().print("No Rooms Available");
					else
					{
						Query query2 = session.createQuery("from RoomTypes where roomtype= :room");
						query.setParameter("room",request.getParameter("roomtype"));
		
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
