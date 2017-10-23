<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>


<table border='1'>
	<tr>
		<td>商品编号</td>
		<td>商品名称</td>
		<td>商品价格</td>
	</tr>
	<c:forEach items="${ps}" var="p">
		<tr>
			<td>${p.id }</td>
			<td>${p.name }</td>
			<td>${p.price }</td>
		</tr>
	</c:forEach>
</table>
