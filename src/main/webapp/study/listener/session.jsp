<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>

</head>

<body>
	<%
		//session.invalidate();

		session.setAttribute("sname", "svalue"); //添加

		session.setAttribute("sname", "sssss"); //修改

		session.removeAttribute("sname"); //移除
	%>
</body>
</html>
