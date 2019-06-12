<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 2018/6/3 0003
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <jsp:forward page="view/login.jsp"/>
  </body>
</html>
