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
<title>收支记录列表</title>
</head>
<body>
<%@include file="/program/common/navigation_bar.jsp" %>
    <c:if test="${user == null }">
        请先登录
    </c:if>
    <c:if test="${user != null }">
        <a href="${pageContext.request.contextPath}/program/cost/cost_add.jsp">新增</a>
        <form action="${pageContext.request.contextPath}/cost/list">
        <c:if test="${empty wr}">
            无记录
        </c:if>
        <c:if test="${not empty wr}">

            <table border="0" id="form1table" align="center" width="100%" class="tablestyle">
                <thead>
                <tr>
                    <th><input type="checkbox"></th>
                    <th class="">序号</th>
                    <th>记录日期</th>
                    <th>收支类型</th>
                    <th>花费类型</th>
                    <th>金额</th>
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
                            <c:if test="${c.incomeAndOutType == 0}">支出</c:if>
                            <c:if test="${c.incomeAndOutType == 1}">收入</c:if>
                        </td>
                        <td>${c.costType}</td>
                        <td>${c.money }</td>
                        <td>${c.remark}</td>
                        <td>
                            <c:if test="${user != null }">
                                <a href="${pageContext.request.contextPath}/cost?method=selectById&id=${c.id}">编辑</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <%@include file="/program/weightRecord/pageturning.jsp" %>
        </c:if>
        </form>
    </c:if>
<script>
    $("#form1table").tablesorter();
    parse("form1table");
</script>
</body>
</html>