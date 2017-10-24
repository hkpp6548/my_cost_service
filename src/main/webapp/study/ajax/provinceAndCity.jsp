<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ajax开发---简单的省市级联</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/my.js"></script>
<script type="text/javascript">
	var jsonobj = null;
	window.onload = function() {

			//第一步:得到XMLHttpRequest对象.
			var xmlhttp = getXmlHttpRequest();
			//2.设置回调函数
			xmlhttp.onreadystatechange = function() {
				//5.处理响应数据  当信息全部返回，并且是成功
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var responseText = eval("(" + xmlhttp.responseText + ")"); ;
					alert(responseText[0].name);
				}
			};
			//post请求方式，参数设置
			xmlhttp.open("GET", "${pageContext.request.contextPath}/provinceAndCityServlet");
			xmlhttp.send(null);
	};
</script>

</head>

<body>
	<select id="province" onchange="fillCity()">
		<option>--请选择省份--</option>
	</select>
	<select id="city">
		<option>--请选择城市--</option>
	</select>
</body>
</html>
