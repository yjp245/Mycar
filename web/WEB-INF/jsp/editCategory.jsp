<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 2018/5/2 0002
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <form action="updateCategory" >
     id值   <input name="id" value="${c.id}"><br>
       name值 <input name="name" value="${c.name}" type="text"><br><br>
        <input type="submit" value="修改">
    </form>
</head>
<body>

</body>
</html>
