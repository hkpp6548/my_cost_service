<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/js/datePicker.inc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty wr}">
		无记录
	</c:if>
	<c:if test="${not empty wr}">
		<a href="${pageContext.request.contextPath}/program/weightRecord/weight_record_insert.jsp">新增</a>
		<table border="1" align="center" width="65%">
			<tr>
				<td><input type="checkbox"></td>
				<td>记录编号</td>
				<td>记录日期</td>
				<td>有没有跑步</td>
				<td>跑步前体重（斤）</td>
				<td>跑步后体重（斤）</td>
				<td>洗澡后体重（斤）</td>
				<td>睡觉前体重（斤）</td>
				<td>操作</td>
			</tr>

			<c:forEach items="${wr}" var="c">
				<tr>
					<td><input type="checkbox"></td>
					<td>${c.id}</td>
					<td>${c.date}</td>
					<td>
						<c:if test="${c.isRun == 0}">有</c:if>
						<c:if test="${c.isRun == 1}">没有</c:if>
					</td>
					<td>${c.runAgoWeight}</td>
					<td>${c.runAfterWeight }</td>
					<td>${c.bathAfterWeight }</td>
					<td>${c.sleepAgoWeight }</td>
					<td><a href="${pageContext.request.contextPath}/weightRecord/selectById?id=${c.id}">编辑</a></td>
					<%--<td>
						<a href="${pageContext.request.contextPath}/findById?id=${c.id}">编辑</a>
						&nbsp;&nbsp;&nbsp; <a href="javascript:void(0)"
											  onclick="del('${c.id}')">删除</a></td>--%>
				</tr>
			</c:forEach>
			<%--<tr>
				<td colspan="11">
					<a>删除选中</a>
				</td>
			</tr>--%>
		</table>
	</c:if>
</body>
</html>