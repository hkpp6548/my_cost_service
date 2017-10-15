<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>服务器端下载</title>
  </head>
  <body>
      <a href='${pageContext.request.contextPath}/fileDownload1Servlet?filename=wightRecord.txt'>wightRecord.txt</a><br>
      <a href='${pageContext.request.contextPath}/fileDownload1Servlet?filename=account.sql'>account.sql</a><br>
      <a href='${pageContext.request.contextPath}/fileDownload1Servlet?filename=体重记录.txt'>体重记录.txt</a><br>
  </body>
</html>
