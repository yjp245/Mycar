<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 2018/5/1 0001
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>

<body>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${list}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>

        </tr>
    </c:forEach>
</table>


<form action="addCategory">
<input type="text" name="name" value="">
    <br>
    <input type="submit" value="提交">
</form>

<br>

<h2>修改</h2>
<form action="updateCategory">
    <input type="text" name="name" value="">
    <input type="submit" value="提交">
</form>

<h2>删除</h2>
</body>
</html>
