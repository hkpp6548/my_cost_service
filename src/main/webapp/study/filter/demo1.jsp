<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
</head>

<body>
	<form action="${pageContext.request.contextPath}/filter/demo1" method="post">
		username:<input type="text" name="username"> <br> msg:<input
			type="text" name="msg"><br> <input type="submit"
			value="提交">
	</form>
</body>
</html>
