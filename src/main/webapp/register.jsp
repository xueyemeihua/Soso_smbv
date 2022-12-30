<%--
  Created by IntelliJ IDEA.
  User: ly
  Date: 2022/12/28
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div align="center">
    <form action="/Soso_smbv/register" method="post">
        <p style="color: red">${registerError}</p><br>
        用户名:<input name="rusername"><br>
        密码:<input type="password" name="rpwd"><br>
        <input type="submit" value="注册">
    </form>
</div>
</body>
</html>
