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
			
			<h1>Post Your Queries Here</h1>
			<form method="POST" action="GuestQueryServlet">
			<table>
			<tr>
			<td>Name: </td>
			<td><input type="text" maxlength="30" name="postedby" id="postedby"><span id="error_name" class="error">*</span></td>
			</tr>
			<tr>
			<td>e-mail: </td>
			<td><input type="text" maxlength="30" name="email" id="email"><span id="error_email" class="error">*</span></td>
			</tr>
			<tr>
			<td>Query: </td>
			<td><textarea rows="8" cols="30"name="query" >
			</textarea><span id="error_query" class="error">*</span></td>
			</tr>
			<tr>
			<td colspan="2"><input type="submit" value="Post"/></td>
			
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