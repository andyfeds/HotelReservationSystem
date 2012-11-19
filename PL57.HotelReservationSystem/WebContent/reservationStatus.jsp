<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stags Hotel</title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="main">
	  <jsp:include page="header.html" />
	<div id="content">
			<div id="left">
			
			<h1>Reservation Status</h1>
			<div class="box">
			<h2>ROOM BOOKED SUCCESSFULLY</h2>
			<h1>Your PNR Number :<%=request.getAttribute("pnr")%></h1>
			<h6>Please Save your PNR number for further Queries and cancellations.</h6>
			</div>
			</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>