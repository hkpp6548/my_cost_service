<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>测试超链接下载</title>
  </head>
  <body>
      <a href='${pageContext.request.contextPath}/study/fileDownload/file/wightRecord.txt'>wightRecord.txt</a><br>
      <a href='${pageContext.request.contextPath}/study/fileDownload/file/account.sql'>account.sql</a><br>
  </body>
</html>
