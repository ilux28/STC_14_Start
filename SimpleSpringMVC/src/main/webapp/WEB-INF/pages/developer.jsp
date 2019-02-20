<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17.02.2019
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Developer</title>
</head>
<body>
    <h2>Enter Developer information</h2>
    <form:form method="post" action="addDeveloper">
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="specialty">Specialty</form:label></td>
            <td><form:input path="specialty"/></td>
        </tr>
        <tr>
            <td><form:label path="experience">Experience</form:label></td>
            <td><form:input path="experience"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </form:form>
</body>
</html>
