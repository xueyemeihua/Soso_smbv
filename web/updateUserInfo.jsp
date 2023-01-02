<%--
  Created by IntelliJ IDEA.
  User: ly
  Date: 2023/1/2
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
</head>
<body>
<div align="center">
    请填写修改的信息
    <form action="/Soso_smbv/updateUserInfo" method="post">
        姓名:<input name="name"><br>
        电话:<input name="phone"><br>
        身份证:<input name="cardid"><br>
        <input type="submit" value="修改">
    </form>
</div>
</body>
</html>
