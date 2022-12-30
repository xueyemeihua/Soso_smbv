<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ly
  Date: 2022/12/29
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的套餐</title>
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
    <table border="1px" cellpadding="0px" cellspacing="0px">
        <tr>
            <th>业务标题</th>
            <th>业务信息</th>
            <th>业务价格</td>
        </tr>
        <c:forEach var="bus" items="${myBuss}">
            <tr>
                <td>${bus.btitle}</td>
                <td>${bus.binfo}</td>
                <td>${bus.bprice}</td>
            </tr>
        </c:forEach>
    </table>
    <p style="color: red">${showMyBusError}</p>
    <a href="userView.jsp">返回</a>
</div>
</body>
</html>
