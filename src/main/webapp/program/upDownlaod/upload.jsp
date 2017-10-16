<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>上传文件</title>
  </head>
  <body>
    <%--<input type="button" id="add" value="多文件上传" onclick="addFile()">--%>
	<form action="${pageContext.request.contextPath}/uploadServlet" method="post" encType="multipart/form-data">
        <input type="file" name="f"><br>
        上传备注：<textarea name="aaa" id="aaa" cols="10" rows="1"></textarea>
        <div id="content"></div>
		<input type="submit" value="上传">
	</form>
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
