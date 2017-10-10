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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/program/weightRecord/css/default.css" />
<title>体重记录列表</title>
</head>
<body>
	<c:if test="${empty wr}">
		无记录
	</c:if>
    <form action="${pageContext.request.contextPath}/weightRecord/list">
        <c:if test="${not empty wr}">

            <c:if test="${user != null }">
                <a href="${pageContext.request.contextPath}/program/weightRecord/weight_record_insert.jsp">新增</a>
            </c:if>
        <table border="0" id="form1table" align="center" width="100%" class="tablestyle">
            <thead>
                <tr>
                    <th><input type="checkbox"></th>
                    <th class="">序号</th>
                    <th>记录日期</th>
                    <th>有没有跑步</th>
                    <th>跑步前体重(斤)</th>
                    <th>洗澡后体重(斤)</th>
                    <th>备注</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${wr}" var="c" varStatus="status">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${status.count}</td>
                    <td>${c.date}</td>
                    <td>
                        <c:if test="${c.isRun == 0}">有</c:if>
                        <c:if test="${c.isRun == 1}">没有</c:if>
                    </td>
                    <td>${c.runAgoWeight}</td>
                    <td>${c.bathAfterWeight }</td>
                    <td>${c.remark}</td>
                    <td>
                        <c:if test="${user != null }">
                            <a href="${pageContext.request.contextPath}/weightRecord/selectById?id=${c.id}">编辑</a>
                        </c:if>
                    </td>
                        <%--<td>
                            <a href="${pageContext.request.contextPath}/findById?id=${c.id}">编辑</a>
                            &nbsp;&nbsp;&nbsp; <a href="javascript:void(0)"
                                                  onclick="del('${c.id}')">删除</a></td>--%>
                </tr>
            </c:forEach>
            </tbody>

            <%--<tr>
                <td colspan="11">
                    <a>删除选中</a>
                </td>
            </tr>--%>
        </table>
        <%@include file="/program/weightRecord/pageturning.jsp" %>
	</c:if>
    </form>
<script>
    console.log(111);
    $("#form1table").tablesorter();
    parse("form1table");
</script>
</body>
</html>