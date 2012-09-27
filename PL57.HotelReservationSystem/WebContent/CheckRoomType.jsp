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
      dojo.byId("arrival").value = date;
    });
});
dojo.ready(function(){
    // create the dialog:
    var cal_2 = new dojox.widget.Calendar({}, dojo.byId("cal_2"));
    dojo.connect(cal_2, "onValueSelected", function(date){
      dojo.byId("departure").value = date;
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
<%ArrayList<String> dataList=(ArrayList<String>)request.getAttribute("data");
for(int i=0;i<dataList.size();i++) {%>
  <option value="<%=(String)dataList.get(i)%>"><%=(String)dataList.get(i)%></option>
<%} %>
</select>


<div>Arrival Date: </div><div><input type="text" name="arrival" id="arrival"/></div><br />
<div id="cal_1"></div>

<div>Departure Date:</div><div> <input type="text" name="departure" id="departure" /></div><br />
<div id="cal_2"></div>
<div>Number of Rooms:</div><div> <input type="text" name="roomsnum" /></div><br />
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