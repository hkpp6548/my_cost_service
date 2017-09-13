<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>1.jsp</title>
</head>
<body>
    <h3>
        哈喽！
    </h3>

    <%--
        * JSP的脚本元素（JSP的页面可以编写java代码）
			<%!  %>		：定义类、定义变量、定义方法（不常用）	成员变量。
			<%=  %>		：输出语句（输出到页面，不能有分号）
			<%   %>		：定义变量、语句
    --%>
    <%!
        int a = 10;
    %>
    <%=a %>
    <%
        int b = 100;
        if(b == 20){
        }else{
        }
    %>
</body>
</html>
