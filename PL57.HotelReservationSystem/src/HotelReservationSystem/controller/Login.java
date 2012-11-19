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

import HotelReservationSystem.model.Receptionist;


@WebServlet("/Login")

public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	String page="login.jsp";
	

    public Login() 
    {
    	super(); 
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uname,pass;
		
		try {
				HttpSession sessionObj=null;
				SessionFactory sessionFactory=configureSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				
				try {
						Query query = session.createQuery("from Receptionist where username =:username ");
						query.setParameter("username",request.getParameter("username"));
				
						
						
						@SuppressWarnings("unchecked")
						List<Receptionist> userNameList= query.list();
						if(userNameList.size()<=0)
						{
							request.setAttribute("msg","Username Does not exist");
							RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");

							  if (dispatcher != null){

							  dispatcher.forward(request, response);

							  } 
						}							
						else
						{
						uname=userNameList.get(0).getUsername();
						pass=userNameList.get(0).getPassword();
					   	
					   
					    					
							if((uname.equalsIgnoreCase(request.getParameter("username"))) && (pass.equalsIgnoreCase(request.getParameter("password"))) )
							{
								sessionObj=request.getSession(true);
								sessionObj.setAttribute("username", uname);

								 request.setAttribute("msg","Authentication Successfull!!!");
								 RequestDispatcher dispatcher = request.getRequestDispatcher("receptionisthome.jsp");

								  if (dispatcher != null){

								  dispatcher.forward(request, response);

								  } 
							}
					
							else
							{
								
								request.setAttribute("msg","Authentication Failure. Incorrect Username and Password");
								RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");

								  if (dispatcher != null){

								  dispatcher.forward(request, response);

								  } 
							}
							
				       
				}
				}
				
				catch (Exception e) {
										session.getTransaction().rollback();
										System.out.println("ERROR ");
										
									}
			
			
			finally
			{
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
	
