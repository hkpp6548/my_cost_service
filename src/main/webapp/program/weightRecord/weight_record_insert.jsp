<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ include file="/js/datePicker.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/weightRecord/insert" method="post">
		<table border="1" width="50%">
			<tr>
				<td>输入日期</td>
				<td>
					<input type="text" name="date" onClick="WdatePicker()"/>
				</td>
			</tr>
			<tr>
				<td>有没有跑步</td>
				<td>
					<select name="isRun">
						<option value="1">没有</option>
						<option value="0">有</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>跑步前体重（斤）</td>
				<td>
					<input type="text" name="runAgoWeight" />
				</td>
			</tr>
			<tr>
				<td>跑步后体重（斤）</td>
				<td>
					<input type="text" name="runAfterWeight" />
				</td>
			</tr>
			<tr>
				<td>洗澡后体重（斤）</td>
				<td>
					<input type="text" name="bathAfterWeight" />
				</td>
			</tr>
			<tr>
				<td>洗澡后体重（斤）</td>
				<td>
					<input type="text" name="sleepAgoWeight" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交"/>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>