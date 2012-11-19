<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stags Hotel : Cancel Successful</title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="main">
	  <jsp:include page="header.html" />
	<div id="content">
	<h1>Cancel Reservation </h1>
			<div id="left"><div class="box"><span id="errormsg"><%=request.getAttribute("msg") %></span></div>
			</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>