<%@page import="com.skyhuang.study.listener.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>

</head>

<body>
	<%
		session.removeAttribute("user");//移除
	%>
</body>
</html>
