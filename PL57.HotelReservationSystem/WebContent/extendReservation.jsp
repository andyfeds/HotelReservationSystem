<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stags Hotel</title>
<link href="css.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="dojo-release-1.8.0/dojo/../dijit/themes/tundra/tundra.css">
<link href="dojo-release-1.8.0/dojox/widget/Calendar/Calendar.css" rel="stylesheet" type="text/css" />

<script src='dojo-release-1.8.0/dojo/dojo.js' data-dojo-config='parseOnLoad: true'></script>
<script src="validation.js"></script>
<script>require(["dojo/parser", "dijit/form/DateTextBox"]);</script>

<style>
.dijitDateTextBox .dijitArrowButtonInner {
  background: transparent url('images/date.png') center center no-repeat;
  width: 20px;  
  margin: 0;
}

.dijitDateTextBox
{
height: 20px;
}
</style>
</head>
<body class="tundra">
<div id="main">
	  <jsp:include page="ReceptHeader.html" />
	<div id="content">
	
			<div id="left">
			<h1>Extend Guest Stay</h1>
			<form method="POST" action="extendReservationServlet" onSubmit="return (RequiredField(this))">
			<div>Enter PNR Number : <input type="text" name="pnr"  />
			<span id="error_pnr" class="error"></span>
			</div>
			 <div>Enter New Date of Departure : <input constraints="{datePattern:'yyyy-MM-dd'}" data-dojo-id="newdeparture" type="text" name="dodep" id="dodep" value="Select New Date of Departure" data-dojo-type="dijit/form/DateTextBox" 
					required="true" /></div>
			<div><input type="submit" value="Submit"></div> 
			</form>
			</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>