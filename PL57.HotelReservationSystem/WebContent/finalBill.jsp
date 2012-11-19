<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stags Hotel</title>
<link href="css.css" rel="stylesheet" type="text/css" />
<style>
table
{
border:2px solid brown;
}
</style>
</head>
<body>
<div id="main">
	  <jsp:include page="ReceptHeader.html" />
	<div id="content">
			<div id="left">
			<h1>Final Bill</h1>
			<table>
			<tr>
			<td>Guest Name: </td>
			<td><%=request.getAttribute("guestName") %> </td>
			</tr>
			
			<tr>
			<td>Stay Period: </td>
			<td><%=request.getAttribute("stayDuration") %> </td>
			</tr>
			
			<tr>
			<td>Stay Amount: </td>
			<td><%=request.getAttribute("hotelAmount") %> </td>
			</tr>
			
			<tr>
			<td>Restaurant Amount: </td>
			<td><%=request.getAttribute("restaurantAmount") %> </td>
			</tr>
			
			<tr>
			<td>TOTAL AMOUNT: </td>
			<td><%=request.getAttribute("totalAmount") %> </td>
			</tr>
			
			
			</table>
			</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>