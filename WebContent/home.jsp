<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="DimGray">
<marquee scrollamount="25"><font size="9"><center>Welcome To The ABC BANK<%out.print("   "+session.getAttribute("name")); %></center></font></marquee>

<table bgcolor="Gainsboro">
<tr><td><a href="Balance">Check Balance</a></td></tr>
<tr><td><a href="transfer.jsp">Amount Transfer</a></td></tr>
<tr><td><a href="GetStatement">Get Statement</a></td></tr>
<tr><td><a href="changePassword.jsp">Change Password</a></td></tr>
<tr><td><a href="Logout">Logout</a></td></tr>
<tr><td><a href="applyLoan.jsp">Apply Loan</a></td></tr>
</table>
<img src="http://files2.coloribus.com/files/adsarchive/part_1793/17937555/banking-the-power-of-a-dollar-600-97716.jpg" height="450" width="1330">
</body>
</html>