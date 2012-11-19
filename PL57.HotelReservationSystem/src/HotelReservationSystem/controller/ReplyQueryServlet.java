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

import HotelReservationSystem.model.QueryReply;


@WebServlet("/ReplyQueryServlet")
public class ReplyQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ReplyQueryServlet() {
        super();
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		  try {
			  HttpSession ses = request.getSession(true);
			  Transaction tran = null;		
			  SessionFactory sessionFactory=configureSessionFactory();
			  Session session=sessionFactory.openSession();
			  tran=session.beginTransaction();
				try {
					
					Calendar curdate=Calendar.getInstance();
					QueryReply reply=new QueryReply();
					reply.setQueryid((Integer)ses.getAttribute("queryid"));
					reply.setReplybody(request.getParameter("reply"));
					reply.setReplydate(curdate);
					reply.setReplyby("Andy");
					//reply.setReplyby((String)ses.getAttribute("username"));
					
				   
				    session.save(reply);
				    
				   		    
					
				    tran.commit();
				    
				    request.setAttribute("msg","Reply has been sent successfully");
				    RequestDispatcher dispatcher = request.getRequestDispatcher("replyquery.jsp");

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
