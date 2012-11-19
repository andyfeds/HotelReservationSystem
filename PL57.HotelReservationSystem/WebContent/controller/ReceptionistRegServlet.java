package HotelReservationSystem.controller;

import helper.HotelConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

import HotelReservationSystem.model.Receptionist;



@WebServlet("/ReceptionistRegServlet")
public class ReceptionistRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String page = "index.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceptionistRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			  HttpSession ses = request.getSession(true);
			  Transaction tran = null;		
			  SessionFactory sessionFactory=configureSessionFactory();
			  Session session=sessionFactory.openSession();
			  tran=session.beginTransaction();
			
			  try {
				  
				  Calendar dob = new GregorianCalendar();
				  Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));
				  dob.setTime(date);
				  
				  String gender = request.getParameter("Gender");
				  
				  Receptionist receptionist = new Receptionist();
				  
				  receptionist.setFname(request.getParameter("First_Name"));
				  receptionist.setLname(request.getParameter("Last_Name"));
				  receptionist.setUsername(request.getParameter("Username"));
				  receptionist.setDob((GregorianCalendar) dob);
				  receptionist.seteId(request.getParameter("Email_Id"));
				  receptionist.setPassword(request.getParameter("Password"));
				 // receptionist.setM_Number((Integer.parseInt(request.getParameter("Mobile_Number"))));
				  receptionist.setM_Number(request.getParameter("Mobile_Number"));
				  receptionist.setGender(gender);
				  receptionist.setAddress(request.getParameter("Address"));
				  receptionist.setCity(request.getParameter("City"));
				  receptionist.setPin(Integer.parseInt(request.getParameter("Pin_Code")));
				  receptionist.setState(request.getParameter("State"));
				  receptionist.setCountry(request.getParameter("Country"));
				  
				  session.save(receptionist);
				  tran.commit();
				
				  
				  RequestDispatcher dispatcher = request.getRequestDispatcher(page);

				  if (dispatcher != null){

				  dispatcher.forward(request, response);

				  } 
				  
			} catch (Exception e) {
				// TODO: handle exception
				session.getTransaction().rollback();
				System.out.println("Error" + e);
			}
			  finally{
				  session.close();
			  }
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
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
