package reservation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class guestReservationServlet
 */
@WebServlet("/guestReservationServlet")
public class guestReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public guestReservationServlet() {
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
		try {
		 PrintWriter out=response.getWriter();
	       out.println("<html>");
	    out.println("<head><title>Guest Details</title></head>");

	    out.println("<body>");
	    	HotelConnection hc=new HotelConnection();
	    	Connection connect = hc.connect();
	        String firstname=request.getParameter("firstname");
	        String lastname=request.getParameter("lastname");
	        String address=request.getParameter("address");
	        String phnum=request.getParameter("phnum");
	        String email=request.getParameter("email");
	        
	        String insertquery="insert into guest(gfname,glname,gaddress,gphone,gemail) values(?,?,?,?,?)";
	        


	        PreparedStatement stmt=connect.prepareStatement(insertquery,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

	        stmt.setString(1,firstname);
	        stmt.setString(2,lastname);
	         stmt.setString(3,address);
	          stmt.setString(4,phnum);
	           stmt.setString(5,email);


	        stmt.executeUpdate();


	        connect.close();


	        out.println("<h3>THANK YOU......You are now a member</h3>");
	        out.println("<a href=displayPNR.jsp>Click To display your PNR</a>");
	    out.println("</body>");
	out.println("</html>");
	}
	catch(Exception e)
	{
	    System.out.println("error"+e);
	}


	}

}
