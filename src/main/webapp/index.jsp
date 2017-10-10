<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/program/weightRecord/css/div.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎访问skyhuang首页</title>
</head>
<body>
    <div style="margin-top: 5%;">
        <div style="width: 50%;margin-left: 25%">
            <h2>欢迎访问凯哥的个人空间，请您先登录！</h2>
            <div class="red">${message}</div>
            <form action="${pageContext.request.contextPath}/wrlogin" method="post">
                <div style="float: left;width: 70px;">用户名:</div><div style="float: left"><input type="text" name="username"></div><br>
                <div style="float: left;width: 70px;">密码:</div><div style="float: left" ><input type="password" name="password"></div><br>
                <input type="checkbox" name="autoLogin" value="0">自动登录<br>
                <input type="submit" value="提交">
                <a href="${pageContext.request.contextPath}/program/weightRecord/index.jsp">访客登录</a>
            </form>
        </div>
    </div>
</body>
</html>
