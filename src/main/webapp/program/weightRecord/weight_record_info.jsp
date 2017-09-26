<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/weightRecord/updateById" method="post">
		<a href="${pageContext.request.contextPath}/weightRecord/list">返回列表界面</a>
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
			<tr>
				<td><input type="checkbox"></td>
				<td><input type="text" name="id" value="${wr.id}" readonly="readonly"></td>
				<td><input type="text" name="date" value="${wr.date}"></td>
				<td>
					<c:if test="${wr.isRun == 0}">
						<select name="isRun">
							<option value="0" selected="selected">有</option>
							<option value="1">没有</option>
						</select>
					</c:if>
					<c:if test="${wr.isRun == 1}">
						<select name="isRun">
							<option value="0">有</option>
							<option value="1" selected="selected">没有</option>
						</select>
					</c:if>
				</td>
				<td><input type="text" name="runAgoWeight" value=" ${wr.runAgoWeight}"></td>
				<td><input type="text" name="runAfterWeight" value=" ${wr.runAfterWeight }"></td>
				<td><input type="text" name="bathAfterWeight" value=" ${wr.bathAfterWeight }"></td>
				<td><input type="text" name="sleepAgoWeight" value=" ${wr.sleepAgoWeight }"></td>
				<td><input type="submit" value="修改"></td>
			</tr>
		</table>
	</form>
</body>
</html>