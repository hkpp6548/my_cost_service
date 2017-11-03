<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/program/weightRecord/css/div.css"/>--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>estore注册页面</title>
    <link rel="stylesheet" href="style.css" type="text/css" media="screen" />
</head>
<body>
<center>
    <br> <br> ${requestScope["regist.message"] } <br>
    <%--<c:forEach items="${map}" var="entry">
    ${entry.value}<br>
</c:forEach>
--%>
    <br>
</center>
<form id="f" action="${pageContext.request.contextPath}/user?method=regist" method="post" onsubmit="return checkForm();">
    <table align="center">
        <caption>注册页面</caption>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" id="username"><span style="color: red;"
                    id="username_message">${map["regist.username.error"] }</span></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" id="password"><span style="color: red;"
                    id="password_message">${map["regist.password.error"] }</span>
            </td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input type="password" name="repassword" id="repassword"><span  style="color: red;"
                    id="repassword_message"></span>
            </td>
        </tr>
        <tr>
            <td>昵称:</td>
            <td><input type="text" name="nickname" id="nickname"><span  style="color: red;"
                    id="nickname_message"></span></td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td><input type="text" name="email" id="email"><span    style="color: red;"
                    id="email_message"></span></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" name="checkcode" id="checkcode"><img
                    src="${pageContext.request.contextPath}/checkImg"
                    onclick="changeImage();" id="cimg"><span id="checkcode_message" style="color: red;">${checkcode_message}</span>
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

    //这里只做非空校验
    function checkForm() {
        //待优化，清空之前的错误信息
        document.getElementById("username_message").innerHTML= "";
        document.getElementById("password_message").innerHTML= "";
        document.getElementById("nickname_message").innerHTML= "";
        document.getElementById("email_message").innerHTML= "";
        document.getElementById("checkcode_message").innerHTML= "";
        document.getElementById("repassword_message").innerHTML= "";

        var f1=checkNull("username");

        var f2=checkNull("password");

        var f3=checkNull("repassword");

        var f4=checkNull("nickname");

        var f5=checkNull("email");

        var f6=checkNull("checkcode");

        var f7=document.getElementById("password").value==document.getElementById("repassword").value;

        if(!f7){
            document.getElementById("repassword_message").innerHTML="<font color='red'>两次密码不一致</font>";
        }

        return f1&&f2&&f3&&f4&&f5&&f6&&f7;

    };

    //使用正则表达式验证非空
    function checkNull(fieldName){
        var value = document.getElementById(fieldName).value;

        var reg = /^\s*$/; //代表0个或多个空字符。

        if(reg.test(value)){
            document.getElementById(fieldName+"_message").innerHTML="<font color='red'>"+fieldName+"不能为空</font>";
            return false;
        }else{
            return true;
        }

    }

    //更换验证码图片
    function changeImage() {
        document.getElementById("cimg").src = "${pageContent.request.contextPath}/checkImg?time=" + new Date().getTime();
    }
</script>
</html>
