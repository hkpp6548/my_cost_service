<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/js/datePicker.inc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收支记录更新</title>
</head>
<body>
<%@include file="/program/common/navigation_bar.jsp" %>
	<form action="${pageContext.request.contextPath}/cost?method=updateById" method="post">
		<a href="${pageContext.request.contextPath}/cost/list">返回列表界面</a>
		<table border="1" align="center" width="65%">
			<tr>
				<td><input type="checkbox"></td>
				<td>记录日期</td>
				<td>收支类型</td>
				<td>花费类型</td>
				<td>金额</td>
				<td>备注</td>
				<td>操作</td>
			</tr>
			<tr>
				<td><input type="checkbox"></td>
				<input type="hidden" name="id" value="${wr.id}">
				<td>
					<input type="text" name="date" onClick="WdatePicker()" value="${wr.date}">
				</td>
				<td>
					<select name="incomeAndOutType" onchange="changeCostType()">
						<option value="0" <c:if test="${wr.incomeAndOutType == 0}"> selected="selected" </c:if>>支出</option>
						<option value="1" <c:if test="${wr.incomeAndOutType == 1}"> selected="selected" </c:if>>收入</option>
					</select>
				</td>
				<td>
                    <c:if test="${wr.incomeAndOutType == 0}">
                        <select name="costType" id="costType">
                            <option value = '食品消费支出'>食品消费支出</option>
                            <option value = '衣着消费支出'>衣着消费支出</option>
                            <option value = '医疗保健支出'>医疗保健支出</option>
                            <option value = '交通费支出'>交通费支出</option>
                            <option value = '通信网络支出'>通信网络支出</option>
                            <option value = '文化教育支出'>文化教育支出</option>
                            <option value = '住房支出'>住房支出</option>
                            <option value = '旅游支出'>旅游支出</option>
                            <option value = '日常生活支出'>日常生活支出</option>
                            <option value = '投资支出'>投资支出</option>
                            <option value = '借出去的'>借出去的</option>
                        </select>
                    </c:if>

                    <c:if test="${wr.incomeAndOutType == 1}">
                        <select name="costType" id="costType">
                            <option value = '理财收入'>理财收入</option>
                            <option value = '工资收入'>工资收入</option>
                            <option value = '别人还钱'>别人还钱</option>
                        </select>
                    </c:if>
                    <input type="hidden" id="costTypeValue" value="${wr.costType}">
                </td>
				<td><input type="text" name="money" value=" ${wr.money }"></td>
				<td><input type="text" name="remark" value=" ${wr.remark }"></td>
				<td><input type="submit" value="确认修改"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
    window.onload = function(){
        defaultSelect();
    }

    function changeCostType() {
        var incomeAndOutTypeValue = document.getElementsByName("incomeAndOutType")[0].value;
        var value = null;
        if(incomeAndOutTypeValue == 0){
            value =  "<option value = '食品消费支出'>食品消费支出</option>";
            value += "<option value = '衣着消费支出'>衣着消费支出</option>";
            value += "<option value = '医疗保健支出'>医疗保健支出</option>";
            value += "<option value = '交通费支出'>交通费支出</option>";
            value += "<option value = '通信网络支出'>通信网络支出</option>";
            value += "<option value = '文化教育支出'>文化教育支出</option>";
            value += "<option value = '住房支出'>住房支出</option>";
            value += "<option value = '旅游支出'>旅游支出</option>";
            value += "<option value = '日常生活支出'>日常生活支出</option>";
            value += "<option value = '投资支出'>投资支出</option>";
            value += "<option value = '借出去的'>借出去的</option>";
        } else {
            value =  "<option value = '理财收入'>理财收入</option>";
            value += "<option value = '工资收入'>工资收入</option>";
            value += "<option value = '别人还钱'>别人还钱</option>";
        }
        document.getElementById("costType").innerHTML = value;
    }

    function defaultSelect(){
        var costTypes = document.getElementsByName("costType")[0];
        var options = costTypes.options;
        var costTypeValue = document.getElementById("costTypeValue").value;
        for(var i = 0;i < options.length; i++){
            if(costTypeValue == options[i].value){
                options[i].selected = "selected";
            }
        }
    }


</script>
</html>