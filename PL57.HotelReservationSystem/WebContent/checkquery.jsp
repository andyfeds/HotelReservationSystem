<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="HotelReservationSystem.model.GuestQuery"%>
  <%@page language="java" import="java.util.*" %>

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
			
			
<%

ArrayList<GuestQuery> dataList=(ArrayList<GuestQuery>)request.getAttribute("data");
for(int i=0;i<dataList.size();i++){
%>
 
			<table>
			<tr>
			<td colspan="4"><%=(String)dataList.get(i).getBody()%></td>
			</tr>
			<tr>
			<td>Posted By : </td>
			<td><%=(String)dataList.get(i).getPostedby()%></td>
			<td>Date posted: </td>
			<td><%=(Date)dataList.get(i).getDate().getTime()%></td>
			</tr>
			
			<tr>
			<td><a href="replyquery.jsp?body=<%=(String)dataList.get(i).getBody()%>&email=<%=(String)dataList.get(i).getEmail()%>">Reply</a></td>
			</tr>
			<%} %>
			</table>
			
			</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>