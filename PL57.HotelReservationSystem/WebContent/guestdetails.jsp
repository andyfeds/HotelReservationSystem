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
			<div id="left"><div >
<form method="POST" action="guestReservationServlet">
<div>First name:</div><div> <input type="text" name="firstname" /></div><br />
<div>Last name: </div><div><input type="text" name="lastname" /></div><br />
<div>Address: </div><div><textarea rows="5" cols="17" name="address" ></textarea></div><br />
<div>Phone No.:</div><div> <input type="text" name="phnum" /></div><br />
<div>Email: </div><div><input type="text" name="email" /></div><br />
<input type="submit" value="Next">
</form>
</div></div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>