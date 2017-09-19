<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>转账汇款</title>
</head>
<body>
    <form action="/transfer" method="post">
        转入账户:<input type="text" name="accountin"><br>
        转出账户:<input type="text" name="accountout"><br>
        金额:<input type="text" name="money"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
