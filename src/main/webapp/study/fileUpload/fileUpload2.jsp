<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>上传中文乱码问题</title>
  </head>
  <body>
	<form action="${pageContext.request.contextPath}/fileUpload2Servlet" method="post" encType="multipart/form-data">
		<input type="text" name="content"><br>
		<input type="file" name="f"><br>
		<input type="submit" value="上传">
	</form>
  </body>
</html>
