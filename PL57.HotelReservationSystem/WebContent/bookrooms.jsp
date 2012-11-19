<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.util.*" %>
   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stags Hotel</title>
<link href="css.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="dojo-release-1.8.0/dojo/../dijit/themes/tundra/tundra.css">
<link href="dojo-release-1.8.0/dojox/widget/Calendar/Calendar.css" rel="stylesheet" type="text/css" />

<script src='dojo-release-1.8.0/dojo/dojo.js' data-dojo-config='parseOnLoad: true'></script>

<script>require(["dojo/parser", "dijit/form/DateTextBox"]);</script>
<script src="validation.js"></script>
<style>
.dijitDateTextBox .dijitArrowButtonInner {
  background: transparent url('images/date.png') center center no-repeat;
  width: 20px;  
  margin: 0;
}

.dijitDateTextBox
{
height: 20px;
}
</style>
</head>
<body class="tundra">
<div id="main">
	  <jsp:include page="header.html" />
	<div id="content">
			<div id="left">



<div>
<h1>Book Rooms</h1>
<form class="form" method="POST" action="checkRoomTypeServlet" onSubmit="return RequiredField(this);">
<table>
<tr><td>
Type of Room :</td>
<td>
<select name="roomtype">
<%
ArrayList<String> dataList=(ArrayList<String>)request.getAttribute("data");
for(int i=0;i<dataList.size();i++) {%>
  <option value="<%=(String)dataList.get(i)%>"><%=(String)dataList.get(i)%></option>
<%} %>
</select>
</td>
</tr>

<tr><td>
<label for="arrival">Arrival Date :</label></td>
<td>
<input constraints="{datePattern:'yyyy-MM-dd'}" data-dojo-id="arrival" type="text" name="arrival" id="arrival" value="Select Arrival Date" data-dojo-type="dijit/form/DateTextBox" 
required="true" onChange="departure.constraints.min = arguments[0];" /><span id="error_arrival" class="error">*</span>
</td>
</tr>

<tr><td>
<label for="departure">Departure Date :</label></td><td>
<input constraints="{datePattern:'yyyy-MM-dd'}" data-dojo-id="departure" type="text" name="departure" id="departure" value="Select Departure Date" data-dojo-type="dijit/form/DateTextBox" 
required="true" onChange="arrival.constraints.max = arguments[0];"/><span id="error_departure" class="error">*</span></td>
</tr>

<tr><td>Number of Rooms :</td><td>
<select name="roomsnum">
 <%
 int i;
 for(i=1;i<=2;i++){
 %>
 <option value="<%=i%>"><%=i%></option>
<%} %>
 </select>
 </td>
 </tr>



<tr><td>Adults :</td><td>
 <select name="adults">
 <option value="1">1 Adult</option>
 <option value="2">2 Adults</option>
 </select>
 </td>
 </tr>


<tr><td>Children : (Below age of 8)</td>
<td>
 <select name="children">
 <option value="0">No Children</option>
 <option value="1">1 Child</option>
 <option value="2">2 Children</option>
 </select>
 </td>
 </tr>

<tr>
<td colspan="2">
<input type="submit" value="Check Room Availability" name="btn_checkRoom"/>
</td>
</tr>
</table>
</form>

	<div id="roomstatus">
	<%if(request.getAttribute("msg")!=null) {%>
	<span class="error"><%=request.getParameter("msg") %></span><%}%>
	
	</div>
</div>





</div>



			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>