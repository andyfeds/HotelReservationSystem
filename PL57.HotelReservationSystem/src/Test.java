import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import HotelReservationSystem.model.RoomTypes;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
			//RoomTypes r=new RoomTypes();
			//r.setRoomtypeid(54);
			
			SessionFactory sessionFactory=configureSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			try {
					//Query query = session.createQuery("from RoomTypes");
				Query query = session.createQuery("from RoomTypes where roomtype= :room");
				query.setParameter("room","Single Bed A/C");
					@SuppressWarnings("unchecked")
					List<RoomTypes> list= query.list();
					
			for (int i = 0; i < list.size(); i++)
			{
				System.out.println(list.get(i).getRoomType());
			}
			
			
			} catch (Exception e) {
				session.getTransaction().rollback();
				System.out.println("Error");
			}
			finally{
				session.close();
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
