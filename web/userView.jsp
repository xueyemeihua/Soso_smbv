<%--
  Created by IntelliJ IDEA.
  User: ly
  Date: 2022/12/28
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <style>
        td {
            width: 100px;
            height: 50px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div align="center">
        <table border="0px" cellspacing="0px" cellpadding="0px">
            <tr>
                <td style="text-align: right">用户名:</td>
                <td>${loginUser.username}</td>
            </tr>
            <tr>
                <td style="text-align: right">姓名:</td>
                <td>${loginUser.name}</td>
            </tr>
            <tr>
                <td style="text-align: right">电话:</td>
                <td>${loginUser.phone}</td>
            </tr>
            <tr>
                <td style="text-align: right">身份证</td>
                <td>${loginUser.cardid}</td>
            </tr>
            <tr>
                <td style="text-align: right">余额:</td>
                <td>${loginUser.money}</td>
            </tr>
            <tr>
                <td style="text-align: right">积分:</td>
                <td>${loginUser.points}</td>
            </tr>
        </table>
        <a href="/Soso_smbv/showMyBusiness">我的套餐</a><br>
        <a href="/Soso_smbv/buyBusiness">办理业务</a><br>

<%--        ../表示返回上一级目录--%>
        <a href="index.jsp">返回主页</a>
    </div>
</body>
</html>
