<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>3.jsp</title>
</head>
<body>
<%--
    		* EL快速入门
			* 获取域对象中的内容		request.setAttribute("xx","yy");
			${xx}
--%>
<%
    request.setAttribute("aa", "苍老师");
%>
<%= request.getAttribute("aa") %>
${ aa }
</body>
</html>
