<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/10 0010
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<div id="menuContent" style="background-color: #173e65;color: #ffffff; height: 100px;">
     <h1 style="margin-left: 10px; margin-top: 10px;">水果网络销售平台</h1>
     <br/>
     <div style="margin-left: 10px;">
         <a>货物管理</a>|
         <a href="${pageContext.request.contextPath}/retailer/list.action?status=-1">零售商管理</a>|
         <a>购销合同</a>|
         <a>用户设置</a>
     </div>
     <div style="background-color: #cccccc">
         <span style="margin-left: 10px;">欢迎您, ${sessionScope.user.aclName}</span>
     </div>
</div>
