<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stags Hotel</title>
<link href="css.css" rel="stylesheet" type="text/css" />
<script src="validation.js"></script>
</head>
<body>
<div id="main">
	  <jsp:include page="header.html" />
	<div id="content">
			<div id="left">
			
<form name="frm" class="form" method="POST" action="guestReservationServlet" onSubmit="return (checkValid(this) && validateEmail() && RequiredField(this) && validateNumber(this));">
<table>
<tr>
<td>First name:</td>
<td><input type="text" name="firstname" />
<span id="error_firstname" class="error">*</span></td>
</tr>

<tr>
<td>Last name: </td>
<td><input type="text" name="lastname" />
<span id="error_lastname" class="error">*</span></td>
</tr>

<tr>
<td>Address: </td>
<td><textarea rows="5" cols="17" name="address" >
</textarea><span id="error_address" class="error">*</span></td>
</tr>

<tr>
<td>Phone No.:</td>
<td><input type="text" name="phnum" />
<span id="error_phnum" class="error">*</span></td>
</tr>

<tr>
<td>Email:</td>
<td><input type="text" name="email" />
<span id="error_email" class="error">*</span>
</td>
</tr>

<tr>
<td>CARD DETAILS</td>
</tr>

<tr>
<td>Select Card Type :</td>
<td><img src="images/1.jpg" Height="40px" Width="70px" />
		<input class=radio type="radio" name="card" id="c1" checked="checked" />	
<img src="images/2.jpg" Height="40px" Width="70px" />
		<input class=radio type="radio" name="card" id="c2" />
		<span id="error_card" class="error">*</span>
		 </td>
</tr>
<tr>
<td>Expiry Date :</td>
<td><select name="expiry">	
	<%for(int i=2012;i<2020;i++){%>
		<option><%=i%>/<%=i%></option>
		<%} %>
	</select></td>
</tr>

<tr>	
<td>Card No. :</td>
<td> <input type=text name='cardno' maxlength=19 size=20></td>
<td><span id="error_cardno" class="error">*</span></td>
</tr>

<tr>
<td>Card Security Code (CVV) :</td>
<td> <input type="text" name="cvv"/><span id="error_cvv" class="error">*</span></td>
</tr>
<tr>
<td><input type="submit" value="Book Room"/></td>
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