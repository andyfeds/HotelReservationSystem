<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" rel="stylesheet" type="text/css" />
<title>Checkout Success</title>
</head>
<body>
	<div id="main">
	 <jsp:include page="ReceptHeader.html"/>
	<div id="content">
			<div id="left">
			<h1>Check Out Guest</h1>
			<div>
					<h4>Successful Check Out!!!!</h4>
					<form method="POST" action="BillServlet">
					<input type="submit" value="Generate Bill"/>
					</form>
			</div>
	</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>
</body>
</html>