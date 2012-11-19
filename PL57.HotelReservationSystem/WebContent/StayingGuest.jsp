<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page language="java" import="HotelReservationSystem.model.Guest" %>
     <%@page language="java" import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" rel="stylesheet" type="text/css" />
<title>List Of Guests Staying..</title>
</head>
<body>

<div id="main">
	  <jsp:include page="ReceptHeader.html" />
	<div id="content">
			<div id="left">
			<h1>Staying Guests</h1>
			<div>

	<table>
		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
			<th>Phone No.</th>
		</tr>
		
		<%
			ArrayList<Guest> dataList = (ArrayList<Guest>)request.getAttribute("guestData");	
			for(int i=0;i<dataList.size();i++) {%>
		  	<tr>
		  		<td><%=(String)dataList.get(i).getGfname()%></td>
		  		<td><%=(String)dataList.get(i).getGaddress()%></td>
		  		<td><%=(String)dataList.get(i).getGemail()%></td>
		  		<td><%=(String)dataList.get(i).getGphone()%></td>
		  	</tr>
			<%}
		
		%>
	
	</table>
	<!--  <h1>Staying :)</h1> -->
	</div>
	</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
	</div>

</body>
</html>