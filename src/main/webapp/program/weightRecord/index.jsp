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
    <a href="../upDownlaod/index.jsp" >简单上传下载服务</a><br/>
    -----------------------------测试------------------------------------------------<br/>
<c:if test="${user != null }">
    <a href="${pageContext.request.contextPath}/study/fileUpload/fileUpload1.jsp" >上传测试1</a><br/>
    <a href="${pageContext.request.contextPath}/study/fileUpload/fileUpload2.jsp" >上传测试2</a><br/>
    <a href="${pageContext.request.contextPath}/study/fileUpload/fileUpload3.jsp" >多文件上传测试</a><br/>
    <a href="${pageContext.request.contextPath}/study/fileUpload/fileUpload4.jsp" >目录分离上传测试</a><br/>
    <a href="${pageContext.request.contextPath}/study/fileDownload/fileDownload1.jsp" >测试超链接下载</a><br/>
    <a href="${pageContext.request.contextPath}/study/fileDownload/fileDownload2.jsp" >测试服务器端下载</a><br/>
    <a href="${pageContext.request.contextPath}/study/fileDownload/fileDownload3.jsp" >使用递归下载</a><br/>
    <a href="${pageContext.request.contextPath}/study/fileDownload/fileDownload4.jsp" >使用队列下载</a><br/>

    <a href="${pageContext.request.contextPath}/fileDownload2Servlet" >测试linux下载</a><br/>
</c:if>

</body>
</html>
