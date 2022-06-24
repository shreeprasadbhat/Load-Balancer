<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flames World</title>
</head>
<body background="<%=request.getContextPath()%>/Resources/Images/Flames1.jpg" >

<%

int no=(Integer)request.getAttribute("totsblen");
	
	if(no==19 ||no==1)
	{
%>
<center>
<br>
<br>
<h3><font class="font-style">Just for fun only
<br>
<br>
<%=request.getAttribute("Firstname") %>
<%out.print(" and "); %>
<%=request.getAttribute("Secondname") %> are Brother and sister </font></h3>
<center><img src="<%= request.getContextPath() %>/Resources/Images/Sister.png" height="500" width="500"></center>
</center>

<%}else if(no==2 ||no==4 ||no==9||no==7){%>

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

<%}else if(no==14 || no==16 || no==18 ||no==3||no==5){ %>

<center>
<br>
<br>
<h3><font class="font-style">Just for fun only
<br>
<br>
<%=request.getAttribute("Firstname") %>
<%out.print(" and "); %>
<%=request.getAttribute("Secondname") %>  are Friend </font></h3>
<center><img src="<%=request.getContextPath() %>/Resources/Images/Friends.gif" /></center>
</center>

<%}else if(no==6||no==11 ||no==15){ %>
<center>
<br>
<br>
<h3><font class="font-style">Just for fun only
<br>
<br>
<%=request.getAttribute("Firstname") %>
<%out.print(" and "); %>
<%=request.getAttribute("Secondname") %> are getting married</font></h3>
<center><img src="<%= request.getContextPath() %>/Resources/Images/Marriage.jpg" ></center>
</center>

<%}else if(no==8||no==13||no==17||no==20){ %>
<center> 
<h3>
<br>
<br>
<font class="font-style">Just for fun only
<br>
<br>
<%=request.getAttribute("Firstname") %>
<%out.print(" and "); %>
<%=request.getAttribute("Secondname") %> are getting Affection</font></h3>
<br>
<img src="<%=request.getContextPath() %>/Resources/Images/Affection.jpg"/>
</center>

<%}else if(no==10){ %>
<center>


<br>
<h3><font class="font-style">Just for fun only
<br>
<br>
<%=request.getAttribute("Firstname") %>
<%out.print(" and "); %>
<%=request.getAttribute("Secondname") %> are following love </font></h3>
<center><img src="<%= request.getContextPath() %>/Resources/Images/Lovers.jpg" height="500" width="500"/></center>
</center>
<%}else {%>
out.println("Bye");
<%} %>

</body>
</html>