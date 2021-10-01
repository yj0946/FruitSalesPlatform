<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/20 0020
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" import="java.util.*"  language="java" %>
<html>
<head>
    <title>test</title>
</head>
      <!--注意Name名字要与实体类javabean中的方法名字一致，否则不能映射-->
      <form action="findUser.action" method="post">
            用户姓名:<input type="text" name="Name"/><br/>
            <input type="submit" value="查询">
      </form>
      <table width="300px;" border=1>
          <tr>
              <td>序号</td>
              <td>姓名</td>
              <td>账号</td>
              <td>电话</td>
          </tr>
          <!--jsp的属性名和方法名一致，但是首字母要小写-->
          <c:forEach items="${userList}" var="fruit" varStatus="status">
              <tr>
                  <td>${status.index+1}</td>
                  <td>${fruit.userName}</td>
                  <td>${fruit.password}</td>
                  <td>${fruit.name}</td>
                  <td>${fruit.telephone}</td>
              </tr>
          </c:forEach>
      </table>
</body>
</html>
