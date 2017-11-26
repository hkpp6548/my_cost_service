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
    <a href="${pageContext.request.contextPath}/cost/list" >收支记录</a><br/>
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
    <a href="${pageContext.request.contextPath}/study/ajax/ajax1.jsp" >测试AJAX1</a><br/>
    <a href="${pageContext.request.contextPath}/study/ajax/ajax2.jsp" >测试AJAX2 带参数</a><br/>
    <a href="${pageContext.request.contextPath}/study/ajax/ajax3.jsp" >测试AJAX3 验证用户名是否可以使用</a><br/>
    <a href="${pageContext.request.contextPath}/study/ajax/ajax4.jsp" >测试AJAX4 显示商品信息1</a><br/>
    <a href="${pageContext.request.contextPath}/study/ajax/ajax5.jsp" >测试AJAX5 显示商品信息2</a><br/>
    <a href="${pageContext.request.contextPath}/study/ajax/ajax6.jsp" >测试AJAX6 xml返回1</a><br/>
    <a href="${pageContext.request.contextPath}/study/ajax/ajax7.jsp" >测试AJAX7 xml返回2</a><br/>
    <a href="${pageContext.request.contextPath}/study/ajax/provinceAndCity.jsp" >测试AJAX8 省市级联</a><br/>
    <a href="${pageContext.request.contextPath}/study/designMode/proxy/login1.jsp" >动态代理--编码过滤测试</a><br/>
    <a href="${pageContext.request.contextPath}/study/designMode/privileges/login.jsp" >动态代理--注解和动态代理控制细粒度测试</a><br/>
</c:if>

</body>
</html>
