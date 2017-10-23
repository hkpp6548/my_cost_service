<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>ajax开发步骤</title>

<script type="text/javascript">

	//第一步:得到XMLHttpRequest对象.
	var xmlhttp = null;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest(); //针对于现在的浏览器包括IE7以上版本
	} else if (window.ActiveXObject) {
		//针对于IE5,IE6版本
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	//2.设置回调函数
	xmlhttp.onreadystatechange=function(){
		//5.处理响应数据  当信息全部返回，并且是成功
		if(xmlhttp.readyState==4&&xmlhttp.status==200){
			alert(xmlhttp.responseText);
		}
	};
	//3.open
	xmlhttp.open("GET","http://localhost/ajax1servlet");
	//4.发送请求 send
	xmlhttp.send(null);//null代表没有参数  如果有参数可以写成:"username=tom&password=123"
</script>

</head>

<body>
	This is my JSP page.
	<br>
</body>
</html>
