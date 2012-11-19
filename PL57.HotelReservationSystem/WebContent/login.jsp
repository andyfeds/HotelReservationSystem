<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stags Hotel: Receptionist Login</title>
<link href="css.css" rel="stylesheet" type="text/css" />
<script src="validation.js"></script>
</head>
<body>
<div id="main">
	  <jsp:include page="header.html" />
	<div id="content">
			<div id="left">
			<h1>Receptionist Login</h1>
			 <form method="POST" action="Login" onSubmit="return RequiredField(this);">
 			 <div>Username : <input type="text" name="username"><span id="error_username" class="error"></span></div>
  			 <div>Password : <input type="password" name="password"><span id="error_password" class="error"></span></div>
   			<div><input type="submit" value="Login"></div> 
   			
   			<div>
   			<%if(request.getAttribute("msg")!=null) {%>
   			<span id="errormsg" class="error"><%=request.getAttribute("msg")%></span>   <%} %>	
   			<span class="tiny"><a class="tiny" href="ReceptionistReg.jsp" >Receptionist Sign In</a></span>		
   			</div>
 			</form>
			</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>