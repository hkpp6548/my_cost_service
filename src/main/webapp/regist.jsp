<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/program/weightRecord/css/div.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>estore注册页面</title>
    <link rel="stylesheet" href="style.css" type="text/css" media="screen" />
</head>
<body>
<form id="f" action="${pageContext.request.contextPath}/index.jsp" method="post">
    <table style="text-align: center">
        <caption>注册页面</caption>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" id="username"><span
                    id="username_message">${map["regist.username.error"] }</span></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" id="password"><span
                    id="password_message">${map["regist.password.error"] }</span>
            </td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input type="password" name="repassword" id="repassword"><span
                    id="repassword_message"></span>
            </td>
        </tr>
        <tr>
            <td>昵称:</td>
            <td><input type="text" name="nickname" id="nickname"><span
                    id="nickname_message"></span></td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td><input type="text" name="email" id="email"><span
                    id="email_message"></span></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" name="checkcode" id="checkcode"><img
                    src="${pageContext.request.contextPath}/checkImg"
                    onclick="changeImage();" id="cimg"><span id="checkcode_message"></span>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
            <td><input type="reset" value="取消"></td>
        </tr>
    </table>
</form>


</body>
<script type="text/javascript">
    //更换验证码图片
    function changeImage() {
        document.getElementById("cimg").src = "${pageContent.request.contextPath}/checkImg?time=" + new Date().getTime();
    }
</script>
</html>
