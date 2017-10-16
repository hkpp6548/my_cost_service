<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>上传文件目录分离</title>
  </head>
  <body>
    <input type="button" id="add" name="addfile" onclick="addFile()">
	<form action="${pageContext.request.contextPath}/fileUpload3Servlet" method="post" encType="multipart/form-data">
		<input type="file" name="f"><br>
        <div id="content"></div>
		<input type="submit" value="上传">
	</form>
  </body>
  <script type="text/javascript">

      function addFile(){
          var div=document.getElementById("content");
          div.innerHTML+="<div><input type='file' name='f'><input type='button' value='remove file' onclick='removeFile(this)'></div>";
      }

      function removeFile(btn){
          document.getElementById("content").removeChild(btn.parentNode);
      }

  </script>
</html>
