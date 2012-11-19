package HotelReservationSystem.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

import HotelReservationSystem.model.Reservation;
import HotelReservationSystem.model.RoomTypes;



@WebServlet("/checkRoomTypeServlet")
public class checkRoomTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String page="guestdetails.jsp";
	
	private boolean isAvailable=false;
    public checkRoomTypeServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");

		
		  try {

								
				SessionFactory sessionFactory=configureSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				try {
						int noRooms;
						Query query = session.createQuery("from RoomTypes where roomtype= :room");
						query.setParameter("room",request.getParameter("roomtype"));
						
						@SuppressWarnings("unchecked")
						List<RoomTypes> list=query.list();
						noRooms=Integer.parseInt(request.getParameter("roomsnum"));
						
				
					if(noRooms>list.get(0).getAvailRooms())
					{
						request.setAttribute("msg","Type of Room selected not available");
						RequestDispatcher dispatcher= request.getRequestDispatcher("/roomtypesServlet");  
							  if (dispatcher != null)
							  dispatcher.forward(request, response);
				
					}
					else
					{
						HttpSession ses = request.getSession(true);
					
						Query query2 = session.createQuery("from Reservation where roomtypeid= :roomID");
						query2.setParameter("roomID",list.get(0).getRoomtypeid());
						
						@SuppressWarnings("unchecked")
						List<Reservation> datelist=query2.list();
						
						
					
						
						Calendar aDate = new GregorianCalendar();						
						Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("arrival"));
						aDate.setTime(date1);
						
										
						Calendar dDate = new GregorianCalendar();						
						Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("departure"));
						dDate.setTime(date2);
						
					if(datelist.size()<=0)
					{						
						isAvailable=true;
						
					}
					else
					{	
						
						
						for(int i=0;i<datelist.size();i++)
						{
						
							if(aDate.before(datelist.get(i).getArrivatDate()) && dDate.before(datelist.get(i).getArrivatDate()))
							{
								isAvailable=true;
							
							}
							else
							{					
								if(aDate.after(datelist.get(i).getDepartureDate())&& dDate.after(datelist.get(i).getArrivatDate()))
								{								
								isAvailable=true;
								}
								else
								{
								isAvailable=false;
								request.setAttribute("msg","Room not available during this period");
								
								RequestDispatcher dispatcher= request.getRequestDispatcher("/roomtypesServlet");  
									  if (dispatcher != null)
									  dispatcher.forward(request, response);
									break;
								}
							
												
							}
						
						}
					}
						
						if(isAvailable==true)
						{

							Query query3 = session.createQuery("from RoomTypes where roomType= :roomType");
							query3.setParameter("roomType",request.getParameter("roomtype"));
							
							@SuppressWarnings("unchecked")
							List<RoomTypes> typelist=query3.list();
							
							
							ses.setAttribute("aDate",aDate);
							ses.setAttribute("dDate",dDate);
							ses.setAttribute("noRooms",noRooms);
							ses.setAttribute("roomsTypeId",typelist.get(0).getRoomtypeid());
							ses.setAttribute("adults",Integer.parseInt(request.getParameter("adults")));
						    ses.setAttribute("children",Integer.parseInt(request.getParameter("children")));

							  //Dispatching request
						    
							  RequestDispatcher dispatcher = request.getRequestDispatcher(page);
							  if (dispatcher != null)
								  dispatcher.forward(request, response);

						}
						
						
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
