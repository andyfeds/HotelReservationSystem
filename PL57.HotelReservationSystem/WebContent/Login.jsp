<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form method="POST" action="Login" onSubmit="return (RequiredField(this))">
   <div>
   		Username : <input type="text" name="username">
   		<span id="error_username" class="error">*</span>
   </div>
   <div>
   		Password : <input type="text" name="password">
   		<span id="error_password" class="error">*</span>
   </div>
   <div><input type="submit" value="Submit"></div> 
 </form>
</body>
</html>