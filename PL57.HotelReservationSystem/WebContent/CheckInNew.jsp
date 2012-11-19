<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" rel="stylesheet" type="text/css" />
<title>Check In New</title>
</head>
<body>
	
	<div id="main">
	  <jsp:include page="ReceptHeader.html" />
	<div id="content">
			<div id="left">
			<div>
			<h1>Check In Guest</h1>
			<form action="CheckInServlet" method="post">
				<div>Enter PNR :  
					<input name="Pnr" type="text" /><br />
				</div>
				<div><input type="submit" value="Submit"><br /></div>
			</form>
	</div>
	</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
	</div>
	
	
</body>
</html>