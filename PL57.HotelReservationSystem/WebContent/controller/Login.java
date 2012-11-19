package HotelReservationSystem.controller;

import java.io.IOException;
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

import HotelReservationSystem.model.Receptionist;


@WebServlet("/Login")

public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	String page="login.jsp";
	String homePage = "ReceptionistHome.jsp";

    public Login() 
    {
    	super(); 
    }

	/*** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)............*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String u,p;
		
		try {
				SessionFactory sessionFactory=configureSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				
				try {
						Query query = session.createQuery("from Receptionist where username =:username ");
						query.setParameter("username",request.getParameter("username"));
				
						
						
						@SuppressWarnings("unchecked")
						List<Receptionist> userNameList= query.list();
						u=userNameList.get(0).geteId();
						p=userNameList.get(0).getPassword();
					    System.out.println(userNameList);
						
					   
						
					    	
							System.out.println("username :" + userNameList.get(0).geteId() + "password :" + userNameList.get(0).getPassword());
				
							if((u.equals(request.getParameter("username"))) && (p.equals(request.getParameter("password"))) )
							{
								response.getWriter().print("Authentication Successfull!!!");
								
								request.setAttribute("user",u);
								
								RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);

								if (dispatcher != null){

									dispatcher.forward(request, response);

								} 
							}
					
							else
							{
								response.getWriter().print("Incorrect Input...Check Username and Password ");
								
							}
							
				       
				}
				
				catch (Exception e) {
										session.getTransaction().rollback();
										System.out.println("ERROR ");
										response.getWriter().print("User does not exist ");
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
	
