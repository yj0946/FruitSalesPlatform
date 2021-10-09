<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/4 0004
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <c:if test="${user != null}">
        欢迎您, ${user.aclName} + ${user.userName} + ${user.password}
    </c:if>

</body>
</html>
