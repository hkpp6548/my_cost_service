<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>ajax开发---验证用户名是否可以使用</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/my.js"></script>

<script type="text/javascript">
	window.onload = function() {
		//得到id=t的文本框
		var txt = document.getElementById("t");
		//给文本框注册一个失去焦点事件
		txt.onblur = function() {
			
			//获取文本框中的信息
			var value=txt.value;
			//第一步:得到XMLHttpRequest对象.
			var xmlhttp=getXmlHttpRequest();
			//2.设置回调函数
			xmlhttp.onreadystatechange = function() {

				//5.处理响应数据  当信息全部返回，并且是成功
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					
					var msg=xmlhttp.responseText;
					
					document.getElementById("s").innerHTML=msg;
					
				}
			};

			//post请求方式，参数设置
			xmlhttp.open("POST", "${pageContext.request.contextPath}/ajax3servlet");
			xmlhttp.setRequestHeader("content-type",
					"application/x-www-form-urlencoded");
			xmlhttp.send("username="+value);
		}
	};
</script>

</head>

<body>

	<input type="text" name="username" id="t"><span id="s"></span>
	<br>
	<input type="text">

</body>
</html>
