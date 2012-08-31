package reservation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	
public class HotelMain {

	

	

	  public static void main(String args[]) {
	   /*
		  Connection con = null;

	    try {
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      
	      
	      con = DriverManager.getConnection("jdbc:mysql:///hotelreservationdb","root", "");
	      if(!con.isClosed())
	        System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");

	    } catch(Exception e) {
	      System.err.println("Exception: " + e.getMessage());
	    } finally {
	      try {
	        if(con != null)
	          con.close();
	      } catch(SQLException e) {}
	    }
	  }
	  
	  */
		 HotelConnection chkRm = new HotelConnection();
		 //chkRm.connect("Select * from roomtypes");
		 
		  RoomTypes rt = new RoomTypes();
		  rt.displayRoomTypes();
		 
		  Connection con;
		  con = chkRm.getCon();
		  try {
			 if(con!=null)
			con.close();
		  	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  	}
		  
		  
	  }
	}
	

