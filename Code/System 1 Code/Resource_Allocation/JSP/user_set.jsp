<html>
<head>
<title>.:: Cloud Green Computing ::.</title>
<script type="text/javascript">
javascript:window.history.forward(-1);
</script>
<%
	String url=request.getParameter("url");
%>
<frameset name="test1" rows="10%,*"  border="" >
	<frame name="top" src="<%=request.getContextPath()%>/JSP/user_header.jsp" noresize="noresize" scrolling="no"/>
	<frame name="left" src="<%=url %>"  scrolling="no"/>
</frameset>
</head>
<noframes>
<body bgcolor=#111111 >
</body>
</noframes>
</html>