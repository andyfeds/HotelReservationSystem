package reservation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/checkRoomTypeServlet")
public class checkRoomTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page="CheckRoomType.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkRoomTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ResultSet rs;

		  response.setContentType("text/html");

		int avail = 0;
		  try {

		 // Load the database driver
			  HotelConnection chkRm = new HotelConnection();

			  rs = chkRm.connect("Select availrooms from roomtypes where roomtype='Single Bed A/C'");
			 
			  if(!rs.wasNull())
			  {

		  //Add records into data list

				 avail=rs.getInt("availrooms");
						

		
			  	}

		 
		  request.setAttribute("data",avail);

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
