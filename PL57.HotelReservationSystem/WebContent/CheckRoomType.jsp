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
<div>
SELECT TYPE OF ROOM :
</div>
<div>
<select>
  <option value="sbac" selected="selected">Single Bed A/C</option>
  <option value="sbnac">Single Bed Non-A/C</option>
  <option value="dbac">Double Bed A/C</option>
  <option value="dbnac">Double Bed Non-A/C</option>
</select>
</div>
</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>