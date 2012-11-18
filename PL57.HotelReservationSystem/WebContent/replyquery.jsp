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
			
			<h1>Reply To Query</h1>
			<form method="POST" action="ReplyQueryServlet">
			<table>
			<tr>
			<td>Query: </td>
			<%String queryString = request.getQueryString();
			String[] parts;
			String values;
				for (String parameter : queryString.split("&")) {
   				  parts= parameter.split("=");
    			
				
   				 %>
			<td><label for="query"><%=parts[1] %></label></td><%} %>
			</tr>
			
			<tr>
			<td>Reply: </td>
			<td><textarea rows="8" cols="80"name="reply" >
			</textarea><span id="error_reply" class="error">*</span></td>
			</tr>
			<tr>
			<td colspan="2"><input type="submit" value="Reply"/></td>
			
			</tr>
			<tr>
			<td colspan="2"><%=request.getAttribute("msg") %></td>
			</tr>
			</table>
			</form>
			</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>