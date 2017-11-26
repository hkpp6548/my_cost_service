<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/js/datePicker.inc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体重记录更新</title>
</head>
<body>
<%@include file="/program/common/navigation_bar.jsp" %>
	<form action="${pageContext.request.contextPath}/weightRecord/updateById" method="post">
		<a href="${pageContext.request.contextPath}/weightRecord/list">返回列表界面</a>
		<table border="1" align="center" width="65%">
			<tr>
				<td><input type="checkbox"></td>
				<td>记录日期</td>
				<td>有没有跑步</td>
				<td>跑步前体重（斤）</td>
				<td>洗澡后体重（斤）</td>
				<td>备注</td>
				<td>操作</td>
			</tr>
			<tr>
				<td><input type="checkbox"></td>
				<input type="hidden" name="id" value="${wr.id}">
				<td>
					<input type="text" name="date" onClick="WdatePicker()" value="${wr.date}">
				</td>
				<td>
					<select name="isRun">
						<option value="0" <c:if test="${wr.isRun == 0}"> selected="selected" </c:if>>有</option>
						<option value="1" <c:if test="${wr.isRun == 1}"> selected="selected" </c:if>>没有</option>
					</select>
				</td>
				<td><input type="text" name="runAgoWeight" value=" ${wr.runAgoWeight}"></td>
				<td><input type="text" name="bathAfterWeight" value=" ${wr.bathAfterWeight }"></td>
				<td><input type="text" name="remark" value=" ${wr.remark }"></td>
				<td><input type="submit" value="确认修改"></td>
			</tr>
		</table>
	</form>
</body>
</html>