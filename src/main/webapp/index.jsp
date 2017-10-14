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
                <table>
                    <tr>
                        <td style="text-align: right">用户名:</td><td><input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td style="text-align: right">密码:</td><td><input type="password" name="password"></td>
                    </tr>
                </table>
                <input type="checkbox" name="autoLogin" value="0">自动登录<br/>
                <input type="submit" value="提交">
                <a href="${pageContext.request.contextPath}/program/weightRecord/index.jsp">访客登录</a>
            </form>
        </div>
    </div>
</body>
</html>
