<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flames Welcomes to you!!!</title>
<style>
.textbox {
	background: transparent
		url(http://cdn2.editmysite.com/images/util/ui-form/shaded-input-bg.jpg)
		repeat-x;
	border: 1px solid #999;
	outline: 0;
	height: 25px;
	width: 275px;
}

.button {
	border-top: 1px solid #96d1f8;
	background: #65a9d7;
	background: -webkit-gradient(linear, left top, left bottom, from(#3e779d),
		to(#65a9d7) );
	background: -webkit-linear-gradient(top, #3e779d, #65a9d7);
	background: -moz-linear-gradient(top, #3e779d, #65a9d7);
	background: -ms-linear-gradient(top, #3e779d, #65a9d7);
	background: -o-linear-gradient(top, #3e779d, #65a9d7);
	padding: 5px 10px;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	border-radius: 8px;
	-webkit-box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	-moz-box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	text-shadow: rgba(0, 0, 0, .4) 0 1px 0;
	color: white;
	font-size: 14px;
	font-family: Georgia, serif;
	text-decoration: none;
	vertical-align: middle;
}

.button:hover {
	border-top-color: #28597a;
	background: #28597a;
	color: #ccc;
}

.button:active {
	border-top-color: #1b435e;
	background: #1b435e;
}
</style>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>
<body background="<%=request.getContextPath()%>/Resources/Images/Flames1.jpg" onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">

<form action="<%=request.getContextPath() %>/Flames" method="post">
<img src="<%=request.getContextPath()%>/Resources/Images/love-flames-1-b-512x250.jpg" height="215" width="1010"></img>
<center>
<table>

	<tr style="height:  80px;">
		<td ><b><font style="text-shadow: ">Name:</font></b></td>
		<td ><input class="textbox" type="text" name="name1"></td>
		
	</tr>
	
	<tr >
		<td><b><font style="text-shadow: ">Partner Name:</font></b></td>
		<td><input class="textbox" type="text" name="name2"></td>
	</tr>

	
	<tr style="height:  50px;"> 
		<td>
		</td>
		<td>
		<center><input class="button" type="submit" name="Submit"></center>
		</td>
		
		

	</tr>

<tr style="height:  50px;"> 
		
		<td>
		</td>
		
		<td>
		<center><input class="button" type="Reset" name="reset"></center>
		</td>


	</tr>

</table>

</center>
</form>
</body>
</html>