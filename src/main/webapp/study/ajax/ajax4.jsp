<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>ajax开发---显示商品信息</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/my.js"></script>

<script type="text/javascript">
	window.onload = function() {
		//得到id=t的文本框
		var p = document.getElementById("p");

		p.onclick = function() {

			//第一步:得到XMLHttpRequest对象.
			var xmlhttp = getXmlHttpRequest();
			//2.设置回调函数
			xmlhttp.onreadystatechange = function() {

				//5.处理响应数据  当信息全部返回，并且是成功
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

					var msg = xmlhttp.responseText;

					document.getElementById("d").innerHTML = msg;

				}
			};

			//post请求方式，参数设置
			xmlhttp.open("GET", "${pageContext.request.contextPath}/ajax4servlet");

			xmlhttp.send(null);
		};
	};
</script>

</head>

<body>

	<a href="javascript:void(0)" id="p">显示商品信息</a>

	<div id="d"></div>
</body>
</html>
