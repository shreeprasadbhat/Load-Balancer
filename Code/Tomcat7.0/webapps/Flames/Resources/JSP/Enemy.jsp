<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enemy</title>
</head>
<body background="<%=request.getContextPath()%>/Resources/Images/Flames1.jpg" >

<center>
<br>
<br>
<h3><font class="font-style">Just for fun only
<br>
<br>
<%=request.getAttribute("Firstname") %>
<%out.print(" and "); %>
<%=request.getAttribute("Secondname") %> are Enemies</font></h3>
<center><img src="<%= request.getContextPath() %>/Resources/Images/Enemy.png" height="500" width="500"></center>
</center>

</body>
</html>