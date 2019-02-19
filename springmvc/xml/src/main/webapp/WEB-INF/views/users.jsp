<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 19.02.2019
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список пользователей</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div class="container">
        <h2>Список пользователей</h2>
        <form action="${pageContext.servletContext.contextPath}/users" method="post">
            name : <input type="text" name="name"><br/>
            <input type="submit"><br/>
        </form>
        <table border="1">
            <tr>
                <td>Имя</td>

            </tr>
            <c:forEach items="${users}" var="user" varStatus="status">
                <tr valign="top">
                    <td>${user.name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
