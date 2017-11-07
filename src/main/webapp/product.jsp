<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
  	<a href="${pageContext.request.contextPath}/Product_add">product add</a><br>
  	<a href="${pageContext.request.contextPath}/Product_update">product update</a><br>
  	<a href="${pageContext.request.contextPath}/Product_delete">product delete</a><br>
  	<a href="${pageContext.request.contextPath}/Product_search">product search</a><br>
  </body>
</html>
