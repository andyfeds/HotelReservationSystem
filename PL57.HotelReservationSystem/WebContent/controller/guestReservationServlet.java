package HotelReservationSystem.controller;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Random;

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

import HotelReservationSystem.model.Guest;
import HotelReservationSystem.model.Reservation;


@WebServlet("/guestReservationServlet")
public class guestReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String page="reservationStatus.jsp";
	
	
    public guestReservationServlet() {
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
						
					Guest guest= new Guest();				  
				    guest.setGfname(request.getParameter("firstname"));
				    guest.setGlname(request.getParameter("lastname"));
				    guest.setGemail(request.getParameter("email"));
				    guest.setGphone(request.getParameter("phnum"));
				    guest.setGaddress(request.getParameter("address"));
				    session.save(guest);
				    
				   				    
					Reservation res = new Reservation();
					res.setPnr(generatePNR(guest));
				    res.setRoomtypeid((String)ses.getAttribute("roomsTypeId"));
				    res.setArrivatDate((GregorianCalendar)ses.getAttribute("aDate"));
				    res.setDepartureDate((GregorianCalendar)ses.getAttribute("dDate"));
				    res.setGuestId(guest.getGuestId());
				    res.setAdults((Integer)ses.getAttribute("adults"));
				    res.setChildren((Integer)ses.getAttribute("children"));
				    
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
	
	private int generatePNR(Guest guest) {
		String guestid=String.valueOf(guest.getGuestId());
		
		Random rand=new Random();
		int randomNum = rand.nextInt(999- 101+ 1) + 101;
		
		String rno=String.valueOf(randomNum);
		String spnr=guestid+rno;
		int pnr=Integer.parseInt(spnr);
		return pnr;
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
