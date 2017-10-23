<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>ajax开发---xml返回</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/my.js"></script>

<script type="text/javascript">
	window.onload = function() {
		//得到id=t的文本框
		var btn = document.getElementById("btn");

		btn.onclick = function() {

			//第一步:得到XMLHttpRequest对象.
			var xmlhttp = getXmlHttpRequest();
			//2.设置回调函数
			xmlhttp.onreadystatechange = function() {

				//5.处理响应数据  当信息全部返回，并且是成功
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

					var xml = xmlhttp.responseXML;
					
					var div=document.getElementById("content");
					
					var persons=xml.getElementsByTagName("person");
					
					for(var i=0;i<persons.length;i++){
						
						var id=persons[i].getElementsByTagName("id")[0].innerHTML;

						var name=persons[i].getElementsByTagName("name")[0].innerHTML;

						var age=persons[i].getElementsByTagName("age")[0].innerHTML;
						
						div.innerHTML+="id:"+id+"&nbsp;name:"+name+"&nbsp;age:"+age+"<br>";
						
					}
					
				}
			};

			//post请求方式，参数设置
			xmlhttp.open("GET", "${pageContext.request.contextPath}/ajax7servlet");

			xmlhttp.send(null);
		};
	};
</script>

</head>

<body>
	<input type="button" value="接收xml" id="btn">
	
	<div id="content">
	</div>
</body>
</html>
