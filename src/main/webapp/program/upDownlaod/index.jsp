<%--<%@ taglib prefix="c" uri="/struts-tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传下载服务页面</title>
</head>
<body>
<%@include file="/program/common/navigation_bar.jsp" %>
    <h2>请选择您需要的服务</h2>
    <%--上传--%>
    <a href="upload.jsp">上传</a>
    <%--下载--%>
    <a href="${pageContext.request.contextPath}/showDownloadServlet">下载</a>
    <c:if test="${user != null }">
    </c:if>

</body>
</html>
