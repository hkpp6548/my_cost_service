<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>动态代理和注解实现细粒度权限控制 -- 登录页面</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/loginPrivilegesServlet">
        <input name="username" type="text">
        <input name="password" type="password">
        <input type="submit" value="提交">
    </form>
  </body>
</html>
