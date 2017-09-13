<%@ page import="com.skyhuang.utils.CookieUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
<style type="text/css">
	.img1{
		width: 600px;
		height: 300px;
	}
	.img1{
		width: 300px;
		height: 150px;
	}
</style>

</head>
<body>
	
	<img class="img1" src="/img/cookie/1.jpg"><a href="/cookie/product?id=1" >手电筒</a>
	<img class="img1" src="/img/cookie/2.jpg"><a href="/cookie/product?id=2" >电话</a>
	<img class="img1" src="/img/cookie/3.jpg"><a href="/cookie/product?id=3" >电视</a><br/>
	<img class="img1" src="/img/cookie/4.jpg"><a href="/cookie/product?id=4" >冰箱</a>
	<img class="img1" src="/img/cookie/5.jpg"><a href="/cookie/product?id=5" >手表</a>
	<img class="img1" src="/img/cookie/6.jpg"><a href="/cookie/product?id=6" >电脑</a>
	
	<h3>浏览记录</h3>
	<h3><a href="/cookie/remove">清楚浏览记录</a></h3>
<%
	Cookie[] cookies = request.getCookies();
	Cookie id = CookieUtils.getCookieByName(cookies, "product");
	if(id != null){
		String value = id.getValue();
		String[] ids = value.split(",");
		for (String idName: ids) {
			%>
			<img class="img1" src="/img/cookie/<%= idName%>.jpg"></a>
			<%
		}
	}

%>

	
</body>
</html>







