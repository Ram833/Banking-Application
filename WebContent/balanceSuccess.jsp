<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="DarkGray">
<marquee scrollamount="25"><font size="7"><center>Your Balance Is :-<%out.print("  "+session.getAttribute("balance")); %></center></font></marquee>
<img src="https://c1.staticflickr.com/8/7693/17123251389_bed3c3a1ba_b.jpg" height="550" width="1330">
</body>
</html>