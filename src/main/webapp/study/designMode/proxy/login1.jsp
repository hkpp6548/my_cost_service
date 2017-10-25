<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>测试编码过滤动态代理</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/login1">
        <input name="username" type="text">
        <input type="submit" value="提交">
    </form>
  </body>
</html>
