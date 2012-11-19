package HotelReservationSystem.controller;

import java.io.IOException;
import java.util.Calendar;

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

import HotelReservationSystem.model.GuestQuery;

@WebServlet("/GuestQueryServlet")
public class GuestQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GuestQueryServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  try {
			  
			  Transaction tran = null;		
			  SessionFactory sessionFactory=configureSessionFactory();
			  Session session=sessionFactory.openSession();
			  tran=session.beginTransaction();
				try {
						
					
					
					GuestQuery query= new GuestQuery();
					query.setPostedby(request.getParameter("postedby"));
					query.setEmail(request.getParameter("email"));
					Calendar cal = Calendar.getInstance();					
					query.setDate(cal);
					query.setBody(request.getParameter("query"));
					query.setStatus(1);
					
				  
				    session.save(query);
				    tran.commit();
				
				    request.setAttribute("msg","Query has been posted successfully.");
				    RequestDispatcher dispatcher = request.getRequestDispatcher("guestquery.jsp");

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
