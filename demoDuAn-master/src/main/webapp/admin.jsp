<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/28/2021
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/Taphoa?action=create"><button>Them moi</button></a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Ten</th>
        <th>Don Gia</th>
        <th>So Luong</th>
        <th>Sua Xoa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sanpham" items="${listSP}" >
        <tr>
            <td>${sanpham.id}</td>
            <td>${sanpham.sanpham}</td>
            <td>${sanpham.soluong}</td>
            <td>${sanpham.dongia}</td>
            <td><a href="/Taphoa"> <button>Sua Xoa</button> </a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>