<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/program/weightRecord/css/div.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎访问skyhuang首页</title>
</head>
<body>
<form id="f" action="${pageContext.request.contextPath}/index.jsp" method="post">
    <select name="selectcountry" onchange="sendForm()">
        <option>--请选择国家--</option>
        <option value="zn-CN">中国</option>
        <option value="en-US">US</option>
        <%--<option value="zn_CN">中国</option>
        <option value="en_US">US</option>--%>
    </select>
</form>

<%
    String country = request.getHeader("accept-language");
    String selectcountry = request.getParameter("selectcountry");
    if(selectcountry != null){
        country = selectcountry;
        System.out.println(country);
    }

    ResourceBundle bundle = null;
    if(country.startsWith("en-US")){
        bundle=ResourceBundle.getBundle("login",Locale.US);
    }else{
        bundle=ResourceBundle.getBundle("login",Locale.CHINA);
    }

%>

<%--<%
    String country = request.getParameter("country");
    ResourceBundle bundle = null;
    if("us".equals(country)){
        bundle=ResourceBundle.getBundle("login",Locale.US);
    }else{
        bundle=ResourceBundle.getBundle("login",Locale.CHINA);
    }
%>--%>

    <div style="margin-top: 5%;">
        <div style="width: 50%;margin-left: 25%">
            <h2><%--欢迎访问凯哥的个人空间，请先登录！--%> <%=bundle.getString("title") %></h2>
            <div class="red">${message}</div>
            <form action="${pageContext.request.contextPath}/wrlogin" method="post">
                <table>
                    <tr>
                        <td style="text-align: right"><%=bundle.getString("username") %>:</td><td><input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td style="text-align: right"><%=bundle.getString("password") %>:</td><td><input type="password" name="password"></td>
                    </tr>
                </table>
                <input type="checkbox" name="autoLogin" value="0"><%=bundle.getString("automaticlogin") %><br/>

                <input type="checkbox" name="remberAccountAndPassword" value="1">

                <button name="" onclick="test();" value="">测试记住密码</button>

                <input type="submit" value="<%=bundle.getString("submit") %>">
                <a href="${pageContext.request.contextPath}/program/weightRecord/index.jsp"><%=bundle.getString("visitorstologin") %></a>
            </form>
        </div>
    </div>

<%--<br> 使用JSTL国际化标签完成（有乱码问题）
<br>

<fmt:setLocale value="${param.selectcountry}" /><!-- new Local()-->

<fmt:setBundle basename="login" var="bundle" scope="page" /> <!-- ResourceBundle bundle=ResourceBundle.getBundle("message",local) -->
<h1>
    <fmt:message bundle="${bundle }" key="title" /> <!-- bundle.getString(title) -->
</h1>
<hr>
<table>
    <tr>
        <td><fmt:message bundle="${bundle }" key="username" />
        </td>
        <td><input type="text" name="username"></td>
    </tr>

    <tr>
        <td><fmt:message bundle="${bundle }" key="password" />
        </td>
        <td><input type="text" name="password"></td>
    </tr>

    <tr>
        <td colspan="2"><input type="submit"
                               value="<fmt:message bundle="${bundle }" key="submit" />">
        </td>

    </tr>
</table>--%>



</body>
<script type="text/javascript">
    
    function test() {

    }
    
    function sendForm() {
        document.getElementById("f").submit();
    }
</script>
</html>
