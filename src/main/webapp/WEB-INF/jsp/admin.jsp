<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <table>
        <thead>
        <th>ID</th>
        <th>Name</th>
        <th>Password</th>
        <th>Roles</th>
        </thead>
        <c:forEach items="${allAuthors}" var="author">
            <tr>
                <td>${author.id}</td>
                <td>${author.username}</td>
                <td>${author.password}</td>
                <td>
                    <c:forEach items="${author.roles}" var="role">${role.name}; </c:forEach>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin" method="post">
                        <input type="hidden" name="id" value="${author.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">Главная</a>
</div>
</body>
</html>
