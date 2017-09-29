<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div id="pageturning">
    <script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/program/weightRecord/js/webpager.js"></script>
    每页&nbsp;<input id="pageSize" name="pageSize" title="调整每页显示记录条数" onkeyup="return pager.p_key(event,this);" value="${pager.pageSize}" style="width: 30px;text-align:center;height:24px;" />&nbsp;条 &nbsp;
    <input onclick="pager.pre();return false;" title="跳转到上一页" class="buttonleft" readonly="readonly">
    ${pager.currentPage}/${pager.pageNumber}
    <input onclick="pager.next();return false;" title="跳转到下一页" class="buttonright" readonly="readonly">&nbsp;
    <input style="width: 30px;text-align: center;height: 24px;" value="${pager.currentPage}" id="currentPage" name="currentPage" title="请输入要转到的页码数" onkeyup="return pager.p_key(event,this);">/${pager.pageNumber}页
    &nbsp;共${pager.rowNumber}条记录
</div>
</body>
</html>



