<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affection</title>

</head>
<body background="<%=request.getContextPath()%>/Resources/Images/Flames1.jpg" >


<center> 
<h3>
<font class="font-style">
<br>
<br>
<%=request.getAttribute("Firstname") %>
<%out.print(" and "); %>
<%=request.getAttribute("Secondname") %> are getting Affection</font></h3>
<br>
<br>
<h3> <font class="font-style">Just for fun only</font></h3>
 
<img src="<%= request.getContextPath() %>/Resources/Images/Affection.jpg"/>
</center>
</body>
</html>