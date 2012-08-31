<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stags Hotel</title>
<link href="css.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="jquery/development-bundle/themes/base/jquery.ui.all.css">
<script src="jquery/development-bundle/jquery-1.8.0.js"></script>
	<script src="jquery/development-bundle/ui/jquery.ui.core.js"></script>
	<script src="jquery/development-bundle/ui/jquery.ui.datepicker.js"></script>
	<link rel="stylesheet" href="jquery/development-bundle/demos/demos.css">
	<script>
	$(function() {
		$( "#departure" ).datepicker({
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 1,
			onSelect: function( selectedDate ) {
				$( "#arrival" ).datepicker( "option", "minDate", selectedDate );
			}
		});
		$( "#arrival" ).datepicker({
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 1,
			onSelect: function( selectedDate ) {
				$( "#departure" ).datepicker( "option", "maxDate", selectedDate );
			}
		});
	});
</script>
</head>
<body>
<div id="main">
	  <jsp:include page="header.html" />
	<div id="content">
			<div id="left">
			<div>
<form action="">
<div>Type of Room:</div><div><select name="roomType"></select></div><br />
<div>Arrival Date: </div><div><input type="text" name="arrival" /></div><br />
<div>Departure Date:</div><div> <input type="text" name="departure" /></div><br />
<div>Adults: </div><div><input type="text" name="adults" /></div><br />
<div>Children:</div><div> <input type="text" name="children" />(Below age of 8)</div><br />
<div>Number of Rooms:</div><div> <input type="text" name="roomsnum" /></div><br />
<input type="button" value="Next">
</form>
</div>
			</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>