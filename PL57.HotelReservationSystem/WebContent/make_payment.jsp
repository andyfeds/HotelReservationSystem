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
	<h2>MAKE PAYMENT</h2>
     
    <div>Total amount : <Label ID="Label1"></Label></div><br />
	<div>SELECT YOUR PAYMENT OPTION : 
		<label for="credit_card">Credit Card</label>
		<input type="radio" name="gender" id="credit_card" /> 

		<label for="cash">Cash</label>
		<input type="radio" name="gender" id="cash" />    
	</div>
	<br />
	<div>CARD DETAILS </div>
	<div>Select Card Type :
		<img src="images/1.jpg" Height="40px" Width="70px" />
		<input type="radio" name="card" id="c1" /> 
		
		<img src="images/2.jpg" Height="40px" Width="70px" />
		<input type="radio" name="card" id="c2" /> 
	</div>
	<div>Expiry Date :
	<select>
		<option>month</option>
	</select>
	<select>
		<option>year</option>
	</select>
	</div>
	<div>Card No. : <input type="text"/></div>
	<div>Card Security Code (CVV) : <input type="text"/></div>
	<div><input type="submit" value="Continue" /><br /></div>
   <br />
    <div>CASH</div>
	<div><input type="submit" value="Continue" /><br /></div>
	</div>
			</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>