<%@page import="com.skyhuang.study.listener.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>

</head>

<body>
	<%
		User user = new User();
		user.setId(1);
		user.setName("tom");
		
		session.setAttribute("user", user); //绑定
	%>
</body>
</html>
