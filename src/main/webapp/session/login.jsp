<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${msg }
<form action="${pageContext.request.contextPath}/session/checkcode" method="post">
		<table border="1" width="70%">
			<tr>
				<td>输入姓名</td>
				<td>
					<input type="text" name="username" />
				</td>
			</tr>
			<tr>
				<td>输入密码</td>
				<td>
					<input type="password" name="password" />
				</td>
			</tr>
			<tr>
				<td>验证码</td>
				<td>
					<input type="text" name="code" />
					<img id="imgId" src="/session/code">
					<a href="#" onclick="run()">看不清，换一张</a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="登陆"/>
				</td>
			</tr>
		</table>
	</form>
</body>
	<script type="text/javascript">
		// 看不清，换一张，时间戳
		function run(){
			// 获取图片
			var image = document.getElementById("imgId");
			image.src = "/session/code?"+new Date().getTime();
		}
	
	</script>
</html>