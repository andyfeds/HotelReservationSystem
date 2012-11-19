package HotelReservationSystem.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import HotelReservationSystem.model.Reservation;


@WebServlet("/bookRoomServlet")
public class bookRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String page="guestdetails.jsp";
	
    public bookRoomServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		
		  try {
			  HttpSession ses = request.getSession(true);
			   Transaction tran = null;		
				SessionFactory sessionFactory=configureSessionFactory();
				Session session=sessionFactory.openSession();
				tran=session.beginTransaction();
				try {
						
					Reservation res = new Reservation();
				    res.setRoomtypeid((String)ses.getAttribute("roomsTypeId"));
				    res.setArrivatDate((GregorianCalendar)ses.getAttribute("aDate"));
				    res.setDepartureDate((GregorianCalendar)ses.getAttribute("dDate"));
				    res.setGuestId(1);
				    res.setAdults(Integer.parseInt(request.getParameter("adults")));
				    res.setChildren(Integer.parseInt(request.getParameter("children")));
				    
				    session.save(res);
				    
				    tran.commit();
				    
				    RequestDispatcher dispatcher = request.getRequestDispatcher(page);

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
