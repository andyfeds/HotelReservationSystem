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
<script src="validation.js"></script>
<script src='dojo-release-1.8.0/dojo/dojo.js' data-dojo-config='parseOnLoad: true'></script>

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
	  <jsp:include page="header.html" />
	<div id="content">
			<div id="left">
<form action="ReceptionistRegServlet" method="post" onSubmit="return (checkValid(this) && validateEmail() && RequiredField(this) && validateNumber(this) && checkPassConfirm());">
	<div>
		<div>
			<div>FIRST NAME</div>
			<div><input type="text" name="First_Name" maxlength="30"/>
			(max 30 characters a-z and A-Z)
			<span id="error_First_Name" class="error">*</span>
			</div>
		</div>
		
		<div>
			<div>LAST NAME</div>
			<div><input type="text" name="Last_Name" maxlength="30"/>
			(max 30 characters a-z and A-Z)
			<span id="error_Last_Name" class="error">*</span>
			</div>
		</div>
		
		<div>
			<div>EMAIL ID</div>
			<div><input type="text" name="email" maxlength="100" />
			<span id="error_email" class="error">*</span></div>
		</div>
		
		
		<div>
			<div>DATE OF BIRTH</div>
			<div>
<input constraints="{datePattern:'yyyy-MM-dd'}" data-dojo-id="dob" type="text" name="dob" id="dob" value="Select Date of Birth" data-dojo-type="dijit/form/DateTextBox" 
required="true" value="1990-01-01"/>
		<span id="error_dob" class="error">*</span>
			</div>
		</div>
		
		<div>
			<div>USERNAME</div>
			<div><input type="text" name="Username" maxlength="30"/>
			(max 30 characters a-z and A-Z)
			<span id="error_Username" class="error">*</span>
			</div>
		</div>
		
		<div>
			<div>PASSWORD</div>
			<div><input id="pass" type="text" name="Password" maxlength="100" />
			<span id="error_Password" class="error">*</span></div>
		</div>
		
		<div>
			<div>CONFIRM PASSWORD</div>
			<div><input id="c_pass" type="text" name="C_Password" maxlength="100" />
			<span id="error_C_Password" class="error">*</span></div>
		</div>
		
		<div>
			<div>MOBILE NUMBER</div>
			<div><input id="pnumber" type="text" name="Mobile_Number" maxlength="10" onFocus="checkPassConfirm();" />
			(10 digit number)
			<span id="error_phnum" class="error">*</span></div>
			</div>
		</div>

		<div>
			<div>GENDER</div>
			<div>
				Male <input type="radio" name="Gender" value="M" checked="checked"/>
				Female <input type="radio" name="Gender" value="F" />
			</div>
		</div>
		<br/>
		
		<div>
			<div>ADDRESS</div>
			<div><textarea name="Address" rows="4" cols="30"></textarea>
			<span id="error_C_Address" class="error">*</span></div>
		</div>
		
		
		
		<div>
			<input type="submit" value="Submit">
			<input type="reset" value="Reset">
		</div>
	</div>
	</form>
</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>