<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<div id="main">
	  <jsp:include page="header.html" />
	<div id="content">
			<div id="left">
			<div>
			<form action="CheckOutServlet" method="post">
				<div>Enter Check In ID :  
					<input name="CheckInId" type="text" /><br />
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