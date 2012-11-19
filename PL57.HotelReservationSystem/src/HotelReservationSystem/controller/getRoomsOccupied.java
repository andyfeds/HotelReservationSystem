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

import HotelReservationSystem.model.CheckIn;
import HotelReservationSystem.model.Room;

/**
 * Servlet implementation class getRoomsOccupied
 */
@WebServlet("/getRoomsOccupied")
public class getRoomsOccupied extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String page = "RoomsOccupied.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getRoomsOccupied() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			ArrayList<Integer> dataList=new ArrayList<Integer>();
			SessionFactory sessionFactory=configureSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			
			try {
				 	
					Query query = session.createQuery("from Room where Status='occupied'");
					
					List<Room> list=query.list();					
					Iterator<Room> iterator=list.iterator();
					
					while(iterator.hasNext())
					{

						dataList.add(iterator.next().getRoomNo());

					}
					
					request.setAttribute("roomData",dataList);
					  
					RequestDispatcher dispatcher = request.getRequestDispatcher(page);

					if (dispatcher != null){

						dispatcher.forward(request, response);

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
