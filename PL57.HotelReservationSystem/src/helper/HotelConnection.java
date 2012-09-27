package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class HotelConnection {

	
	Connection con = null;
	ResultSet rs = null;
	
	
	public ResultSet connect(String query)
	{
	

	    try {
	    	 
	    	 Class.forName("com.mysql.jdbc.Driver").newInstance();
	      
	      
	    	 con = DriverManager.getConnection("jdbc:mysql:///hotelreservationdb","root", "");
	    	 if(!con.isClosed())
	    	 {
	    		 System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
	    	 	 Statement stmt = con.createStatement();
	    	 	 rs = stmt.executeQuery(query);
	    	 	 
	    	 	 return rs;
	    	 }
	    	 else
	    	 {
	    		 return null;
	    	 }
	    	} catch(Exception e) {
	    		System.err.println("Exception: " + e.getMessage());
	    	} 
	    return rs;
	   
	}

	public Connection connect()
	{
	

	    try {
	    	 
	    	 Class.forName("com.mysql.jdbc.Driver").newInstance();
	      
	      
	    	 con = DriverManager.getConnection("jdbc:mysql:///hotelreservationdb","root", "");
	    	 if(!con.isClosed())
	    	 {
	    		 System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
	    	 	 
	    	 	 return con;
	    	 }
	    	 else
	    	 {
	    		 return null;
	    	 }
	    	} catch(Exception e) {
	    		System.err.println("Exception: " + e.getMessage());
	    	} 
	    return con;
	   
	}


	public Connection getCon() {
		return con;
	}


	public ResultSet getRs() {
		return rs;
	} 
	
	
	public void printRs()
	{
		try {
			while(rs.next())
			{
				System.out.println(rs.getString("roomtype"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

