<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>动态代理和注解实现细粒度权限控制 -- 登录页面</title>
  </head>
  <body>
  当前用户:${user.username}
  <br>
  <hr>
  <a href="${pageContext.request.contextPath}/bookPrivilegesServlet?method=add">book add</a>
  <br>
  <a href="${pageContext.request.contextPath}/bookPrivilegesServlet?method=update">book update</a>
  <br>
  <a href="${pageContext.request.contextPath}/bookPrivilegesServlet?method=delete">book delete</a>
  <br>
  <a href="${pageContext.request.contextPath}/bookPrivilegesServlet?method=search">book search</a>
  <br>
  </body>
</html>
