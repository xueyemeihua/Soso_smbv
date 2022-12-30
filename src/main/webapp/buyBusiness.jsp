<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ly
  Date: 2022/12/30
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买业务</title>

    <style>
        td {
            text-align: center;
            width: 200px;
            height: 100px;
        }
    </style>
</head>
<body>
<div align="center">
    <form action="/Soso_smbv/doBuyBus" method="post">
        购买的业务编号:<input name="bbid"><br>
        <input type="submit" value="购买">
    </form>
<%--    将查询到的可以办理的业务展示--%>
    <table border="1px" cellpadding="0px" cellspacing="0px">
        <tr>
            <th>业务编号</th>
            <th>业务标题</th>
            <th>业务信息</th>
            <th>业务价格</td>
        </tr>
        <c:forEach var="bus" items="${pubBus}">
            <tr>
                <td>${bus.bid}</td>
                <td>${bus.btitle}</td>
                <td>${bus.binfo}</td>
                <td>${bus.bprice}</td>
            </tr>
        </c:forEach>
    </table>
    <p style="color: red">${buyBusError}</p>
    <p style="color: red">${doBuyBusError}</p>
    <a href="userView.jsp">返回</a>
</div>
</body>
</html>
