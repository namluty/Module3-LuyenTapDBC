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
<form method="post" action="Taphoa?action=oder">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Ten</th>
            <th>So Luong</th>
            <th>Don Gia</th>
            <th>Soluong mua</th>
            <th>Them vao gio hang</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sanpham" items="${listSP}">
            <tr>
                <td>${sanpham.id}</td>
                <td>${sanpham.sanpham}</td>
                <td>${sanpham.soluong}</td>
                <td>${sanpham.dongia}</td>
                <td><input name="soluong${sanpham.id}" type="number"/></td>
                <td>
                    <button type="submit" name="idsp" value="${sanpham.id}">Them vao gio hang</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
<c:if test="${giohang!=null}">
    <table>
        <thead>
        <tr>
            <th>STT</th>
            <th>Ten</th>
            <th>Don Gia</th>
            <th>Soluong mua</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="giohang" items="${giohang}" varStatus="item">
            <tr>
                <td>${item.index+1}</td>
                <td>${giohang.sanpham.sanpham}</td>
                <td>${giohang.sanpham.dongia}</td>
                <td>${giohang.soluongmua}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
