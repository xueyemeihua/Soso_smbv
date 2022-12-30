<%--
  Created by IntelliJ IDEA.
  User: ly
  Date: 2022/12/28
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div align="center">
    <form action="/Soso_smbv/login" method="post">
        <p style="color: red">${loginError}</p><br>
        用户名:<input name="lusername" value="${loginUsername}"><br>
        密码:<input type="password" name="lpwd"><br>
        <input type="submit" value="登录">
<%--        Soso_smbv--%>
    </form>
</div>
</body>
</html>
