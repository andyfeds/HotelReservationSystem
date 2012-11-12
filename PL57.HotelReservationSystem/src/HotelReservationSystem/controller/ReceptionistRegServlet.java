package HotelReservationSystem.controller;

import helper.HotelConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ReceptionistReg")
public class ReceptionistRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceptionistRegServlet() {
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
		HotelConnection con = new HotelConnection();
		Connection connect = con.connect();
		
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		  //get the variables entered in the form
		  String fname = request.getParameter("First_Name");
		  String lname = request.getParameter("Last_Name");
		  String dob = request.getParameter("dob");
		  String eId = request.getParameter("Email_Id");
		  String password = request.getParameter("Password");
		  String M_Number = request.getParameter("Mobile_Number");
		  String gender = request.getParameter("Gender");
		  String address = request.getParameter("Address");
		  String city = request.getParameter("City");
		  String pin = request.getParameter("Pin_Code");
		  String state = request.getParameter("State");
		  String country = request.getParameter("Country");
		  
		  String sql = "insert into receptionist(fname,lname,dob,eId,password,M_Number,gender,address,city,pin,state,country) values (?,?,?,?,?,?,?,?,?,?,?,?)";
				  
		  		  PreparedStatement pst;
				
		  		  try {
					
		  		  pst = connect.prepareStatement(sql);
				
				  pst.setString(1, fname);
				  pst.setString(2, lname);
				  pst.setString(3, dob);
				  pst.setString(4, eId);
				  pst.setString(5, password);
				  pst.setString(6, M_Number);
				  pst.setString(7, gender);
				  pst.setString(8, address);
				  pst.setString(9, city);
				  pst.setString(10, pin);
				  pst.setString(11, state);
				  pst.setString(12, country);
				  
				  int numRowsChanged = pst.executeUpdate();
				  // show that the new account has been created
				  out.println(" Hello : ");
				  out.println(numRowsChanged);
				  pst.close();
				  
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		


	}

}
