<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div>
SELECT TYPE OF ROOM :
</div>
<div>
<form method="GET" action="reservation/checkRoomtypeServlet">
<select>

<%ArrayList<String> dataList=(ArrayList<String>)request.getAttribute("data");
for(int i=0;i<dataList.size();i++) {%>
  <option value="<%=(String)dataList.get(i)%>"><%=(String)dataList.get(i)%></option>
<%} %>
</select>
<input type="button" value="Check Room Availability" name="btn_checkRoom"/>
</form>

	<div id="roomstatus">
	
	</div>
</div>
</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>