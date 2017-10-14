<%--<%@ taglib prefix="c" uri="/struts-tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎访问skyhuang首页</title>
</head>
<body>
    <h2>请选择您需要的操作</h2>
    <a href="${pageContext.request.contextPath}/weightRecord/list" >个人体重记录</a><br/>
    -----------------------------测试------------------------------------------------<br/>
    <a href="${pageContext.request.contextPath}/study/fileUpload/fileUpload1.jsp" >上传测试1</a><br/>
    <a href="${pageContext.request.contextPath}/study/fileUpload/fileUpload2.jsp" >上传测试2</a><br/>
    <a href="${pageContext.request.contextPath}/study/fileUpload/fileUpload3.jsp" >多文件上传测试</a>



</body>
</html>
