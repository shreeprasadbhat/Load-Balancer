<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Numerology world</title>
<link rel="StyleSheet" href="<%=request.getContextPath()%>/style.css" ></link>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>
<body
	background="<%=request.getContextPath()%>/Resources/Images/Background.jpg" onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">
<form action="<%=request.getContextPath()%>/Numerology" method="post">
<h1>

</h1>
<center>
	<h1><font color="#006200">Welcome to Numerology world!!!!</font></h1>
	<br></br>
<img
	src="<%=request.getContextPath()%>/Resources/Images/Numerology.jpg" />
<br>

<br>
<table class="CSSTableGenerator" border="0">
	<tr>
		<td>Enter Your Name</td>
		<td><input class="input.example1 " type="text" name="name"></input>
		</td>

	</tr>
	<tr>
		<td>
		<center><input class="btn" type="submit" /></center>
		</td>
		<td>
		<center><input class="btn" type="reset" /></center>
		</td>
	</tr>
</table>

</center>
</form>
</body>
</html>