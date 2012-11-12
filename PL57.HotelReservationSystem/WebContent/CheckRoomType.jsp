<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.util.*" %>
   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Stags Hotel</title>
<link href="css.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="dojo-release-1.8.0/dojo/../dijit/themes/claro/claro.css">
<link href="dojo-release-1.8.0/dojox/widget/Calendar/Calendar.css" rel="stylesheet" type="text/css" />

<script src='dojo-release-1.8.0/dojo/dojo.js' data-dojo-config='parseOnLoad: true'></script><script>dojo.require("dojox.widget.Calendar");

dojo.ready(function(){
    // create the dialog:
    var cal_1 = new dojox.widget.Calendar({}, dojo.byId("cal_1"));
    dojo.connect(cal_1, "onValueSelected", function(date){
    	
    	var theValue = dojo.date.locale.format(arguments[0], {
    	    formatLength: 'short',
    	    selector:'date',datePattern:'yyyy-MM-dd HH:mm'
    	}); 
      dojo.byId("arrival").value = theValue;
    });
});
dojo.ready(function(){
    // create the dialog:
    var cal_2 = new dojox.widget.Calendar({}, dojo.byId("cal_2"));
    dojo.connect(cal_2, "onValueSelected", function(date){
    	var theValue = dojo.date.locale.format(arguments[0], {
    	    formatLength: 'short',
    	    selector:'date',datePattern:'yyyy-MM-dd HH:mm'
    	}); 
      dojo.byId("departure").value = theValue;
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
SELECT TYPE OF ROOM :
</div>
<div>
<form method="POST" action="checkRoomTypeServlet">
<select name="roomtype">

<%
ArrayList<String> dataList=(ArrayList<String>)request.getAttribute("data");
for(int i=0;i<dataList.size();i++) {%>
  <option value="<%=(String)dataList.get(i)%>"><%=(String)dataList.get(i)%></option>
<%} %>
</select>


<div>Arrival Date: </div><div><input type="text" name="arrival" id="arrival"/>
<img id="showcal1" src="images/calendar.png" width="40px" height="40px"/>
</div>

<br />
<div id="cal_1"></div>

<div>Departure Date:</div><div> <input type="text" name="departure" id="departure" />
<img id="showcal2" src="images/calendar.png" width="40px" height="40px"/>
</div><br />
<div id="cal_2"></div>
<div>Number of Rooms:
<select name="roomsnum">
 <%
 int i;
 for(i=1;i<=5;i++){
 %>
 <option value="<%=i%>"><%=i%></option>
<%} %>
 </select>
</div>
<div>Adults:
 <select name="adults">
 <option value="1">1 Adult</option>
 <option value="2">2 Adults</option>
 <option value="4">4 Adults</option>
 <option value="6">6 Adults</option>
 </select>
 </div>
<div>Children: (Below age of 8)
 <select name="children">
 <option value="0">No Children</option>
 <option value="1">1 Child</option>
 <option value="2">2 Children</option>
 <option value="3">3 Children</option>
 <option value="4">4 Children</option>
 </select>
 </div>

<input type="submit" value="Check Room Availability" name="btn_checkRoom"/>
</form>

	<div id="roomstatus">
	
	</div>
</div>
</div>
			<div id="right"></div>
	</div>
	  <jsp:include page="footer.html" />
</div>

</body>
</html>