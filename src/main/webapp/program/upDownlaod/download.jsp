<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/js/datePicker.inc"%>
<%@ include file="/js/handleTable.inc"%>
<link href="<%=request.getContextPath()%>/js/dhfTable.css" type="text/css" rel="stylesheet"/>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/dhfTable.js" type="text/javascript"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>下载文件</title>
  </head>
  <body>
  <%@include file="/program/common/navigation_bar.jsp" %>
    <div class="red">${message}</div>
    简单文件下载列表
    <table border="0" id="form1table" align="center" width="100%" class="tablestyle">
        <thead>
        <tr>
            <th class="">序号</th>
            <th>文件名</th>
            <th>上传时间</th>
            <th>上传备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${downloads}" var="c" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${c.realname}</td>
                <td>${c.uploadtime}</td>
                <td>${c.description}</td>
                <td><a href="${pageContext.request.contextPath}/mydownloadServlet?filename=${c.savepath}&realname=${c.realname}">下载</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
  </body>
  <script type="text/javascript">
      var nameNume = 1;
      function addFile(){
          var div=document.getElementById("content");
          div.innerHTML+="<div><input type='file' name='f"+nameNume+"'><input type='button' value='remove file' onclick='removeFile(this)'></div>";
          nameNume ++;
      }

      function removeFile(btn){
          document.getElementById("content").removeChild(btn.parentNode);
      }

  </script>
</html>
