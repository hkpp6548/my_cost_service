<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div id="navigation_bar">
    <button style="cursor: pointer;" onclick="weightRecordList();">体重记录</button>
    <button style="cursor: pointer" onclick="costList();">消费记录</button>
    <button style="cursor: pointer" onclick="download();">上传下载</button>
</div>
</body>
<script type="text/javascript">
    //点击跳转体重界面
    function weightRecordList() {
        location.href = "${pageContext.request.contextPath}/weightRecord/list";
    }
    //点击跳转消费记界面
    function costList() {
        location.href = "${pageContext.request.contextPath}/cost/list";
    }
    //点击跳转到上传下载界面
    function download() {
        location.href = "${pageContext.request.contextPath}/program/upDownlaod/index.jsp";
    }
</script>
</html>



