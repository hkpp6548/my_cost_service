<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ include file="/js/datePicker.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收支记录新增</title>
</head>
<body>
<%@include file="/program/common/navigation_bar.jsp" %>
<a href="${pageContext.request.contextPath}/cost/list">返回列表界面</a>
	<form action="${pageContext.request.contextPath}/cost?method=add" method="post">
		<table border="1" width="50%">
			<tr>
				<td>输入日期</td>
				<td>
					<input type="text" name="date" onClick="WdatePicker()"/>
				</td>
			</tr>
			<tr>
				<td>收支类型</td>
				<td>
					<select id="incomeAndOutType" name="incomeAndOutType" onclick="changeCostType();">
						<option value="0">支出</option>
						<option value="1">收入</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>花费类型</td>
				<td >
					<select id="costType" name="costType">
						<option value="" >请选择收支类型</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>金额</td>
				<td>
					<input type="text" name="money" />
				</td>
			</tr>
			<tr>
				<td>备注</td>
				<td>
					<input type="text" name="remark" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交" onclick="return check();" />
				</td>
			</tr>
		</table>
	</form>
	
</body>
<script type="text/javascript">

    window.onload = function(){
        changeCostType();
    }

    function check(){
	    console.log("aaaaaaa")
		return true;
	}

	function changeCostType() {
        var obj = document.getElementById("incomeAndOutType");
        var index = obj.selectedIndex; // 选中索引
        var value = obj.options[index].value; // 选中值
		if(value == 0){
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
</script>
</html>