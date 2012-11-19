<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="HotelReservationSystem.model.GuestQuery"%>
  <%@page language="java" import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stags Hotel</title>
<link href="css.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#comment{
		width:90%;
		height:auto;
		padding:10px;
		border:solid #6F3A15 4px;
		margin:10px auto;
		box-shadow: 10px 10px 5px #888;
		background:white;
		}
		</style>

</head>
<body>
<div id="main">



	  <jsp:include page="ReceptHeader.html" />
	<div id="content">
			<div id="left">
			
	<h1>Guest Queries</h1>		
<%

ArrayList<GuestQuery> dataList=(ArrayList<GuestQuery>)request.getAttribute("data");
for(int i=0;i<dataList.size();i++){
	session.setAttribute("queryid",dataList.get(i).getQueryid());
	session.setAttribute("qbody",dataList.get(i).getBody());
	session.setAttribute("qemail",dataList.get(i).getEmail());
%>
 
			<table id="comment">
			<tr>
			<td class="labels">Query:</td>
			<td colspan="4"><%=(String)dataList.get(i).getBody()%></td>
			</tr>
			<tr>
			<td class="labels">Posted By : </td>
			<td class="small"><%=(String)dataList.get(i).getPostedby()%></td>
			<td class="labels">Date posted: </td>
			<td class="small"><%=(Date)dataList.get(i).getDate().getTime()%></td>
			</tr>
			
			<tr>
			<td><a href="replyquery.jsp?queryid=<%=(String)dataList.get(i).getBody()%>&body=<%=(String)dataList.get(i).getBody()%>&email=<%=(String)dataList.get(i).getEmail()%>">Reply</a></td>
			</tr>
			<%
			} 
			%>
			</table>
			
			</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>