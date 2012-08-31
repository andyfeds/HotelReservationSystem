package reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;

/**
 * Servlet implementation class roomtypesServlet
 */
@WebServlet("/roomtypesServlet")
public class roomtypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	  //Setting JSP page
	


	String page="CheckRoomType.jsp";
    /**
     * Default constructor. 
     */
    public roomtypesServlet() {
        // TODO Auto-generated constructor stub
    }

   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();

		  //Establish connection to MySQL database

		  ResultSet rs;

		  response.setContentType("text/html");

		  ArrayList<String> dataList	= new ArrayList<String>(); 

		  try {

		 // Load the database driver
			  HotelConnection chkRm = new HotelConnection();

			  rs = chkRm.connect("Select roomtype from roomtypes");
			 
			  while (rs.next ())
			  {

		  //Add records into data list

				  dataList.add(rs.getString("roomtype"));

		
			  	}

		 
		  request.setAttribute("data",dataList);

		  //Dispatching request

		  RequestDispatcher dispatcher = request.getRequestDispatcher(page);

		  if (dispatcher != null){

		  dispatcher.forward(request, response);

		  } 
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
		  catch(Exception e){

			  System.out.println("Exception is ;"+e);

			  }
	
		
	
	}
	
}
