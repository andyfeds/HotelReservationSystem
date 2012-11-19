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
import HotelReservationSystem.model.Guest;
import HotelReservationSystem.model.Reservation;

/**
 * Servlet implementation class getStayingGuest
 */
@WebServlet("/getStayingGuest")
public class getStayingGuest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String page = "StayingGuest.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getStayingGuest() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			ArrayList<Integer> dataList=new ArrayList<Integer>();
			
			SessionFactory sessionFactory=configureSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			
				try {
					
					Query query = session.createQuery("from CheckIn");
					
					@SuppressWarnings("unchecked")
					List<CheckIn> list=query.list();
					
					Iterator<CheckIn> iterator=list.iterator();		
					while(iterator.hasNext())
					{

						dataList.add(iterator.next().getReserveId());

					}
					
					Iterator<Integer> it = dataList.iterator();
					
					ArrayList<Integer> guestDataList = new ArrayList<Integer>();
					
					while(it.hasNext())
					{
						int resId = it.next().intValue();
						
						System.out.println(resId);
						
						Query Stayquery = session.createQuery("from Reservation where ReserveId = '"+ resId +"' ");
						
						List<Reservation> resList = Stayquery.list();
						guestDataList.add(resList.get(0).getGuestId());
						
						//System.out.println("guest ids "+resList.get(0).getGuestId());
					}
					
					ArrayList<Guest> guestData = new ArrayList<Guest>();
					
					for(int i=0;i<guestDataList.size();i++)
					{
						int guestId =  guestDataList.get(i).intValue();
						
						
						Query GuestStayQuery = session.createQuery("from Guest where guestId = '"+ guestId +"' ");
						
						List<Guest> guestList = GuestStayQuery.list();
						guestData.add(guestList.get(0));
						
						System.out.println("Name = "+ guestList.get(0).getGfname());
						System.out.println("Email = "+ guestList.get(0).getGemail());
						
					}
					
					request.setAttribute("guestData",guestData);
	  
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
