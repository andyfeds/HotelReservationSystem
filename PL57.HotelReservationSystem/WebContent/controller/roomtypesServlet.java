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

import HotelReservationSystem.model.RoomTypes;


@WebServlet("/roomtypesServlet")
public class roomtypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//String page="CheckRoomType.jsp";
	String page="bookrooms.jsp";
    public roomtypesServlet() {
    }

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		  try {

				ArrayList<String> dataList=new ArrayList<String>();
				
				SessionFactory sessionFactory=configureSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				try {
						
						Query query = session.createQuery("from RoomTypes");
												
						@SuppressWarnings("unchecked")
						List<RoomTypes> list=query.list();
						
						Iterator<RoomTypes> iterator=list.iterator();		
						while(iterator.hasNext())
						{

							dataList.add(iterator.next().getRoomType());

		
						}

		 
						request.setAttribute("data",dataList);
		  
						RequestDispatcher dispatcher = request.getRequestDispatcher(page);

						if (dispatcher != null){

							dispatcher.forward(request, response);

						} 
		 
					} 
					catch (Exception e)
					{
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

