<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stags Hotel : Receptionist home</title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="main">
	  <jsp:include page="ReceptHeader.html" />
	<div id="content">
			<div id="left">
			<h1>Receptionist Home</h1>
			<span class="tiny"><%=session.getAttribute("username")%> logged In</span>
			<h2><%=request.getAttribute("msg") %></h2>
			
			
			<h1><%="Welcome "+session.getAttribute("username")%></h1>
			<div class="box">
			<a href="ReceptionistReg.jsp">Registration</a> <br/> <br/>
				<a class ="labels" href="CheckInNew.jsp">Check In</a>   <br/> <br/>
				<a class ="labels" href="CheckOut.jsp">Check Out</a>  <br/> <br/>
				<a class ="labels" href="extendReservation.jsp">Extend Stay</a>  <br/> <br/>
				<a class ="labels" href="getStayingGuest">Guests</a> <br/> <br/>
				<a class ="labels" href="getRoomsOccupied">Rooms Occupied</a> <br/> <br/>
				<a class ="labels" href="GetQueryServlet">Queries</a> <br/> <br/>
				
			</div>
			</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>