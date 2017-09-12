<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>2.jsp</title>
</head>
<body>

<table border="1" width="60%">

    <%
        for(int i=1;i<=10;i++){

    %>
    <tr>
        <%
            for(int j=1;j<=10;j++){

        %>
        <td>1</td>
        <%

            }

        %>
    </tr>
    <%

        }

    %>


</table>

</body>
</html>
