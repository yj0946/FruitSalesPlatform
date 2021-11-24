<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/15 0015
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>零售商管理</title>
    <style>*{margin: 0; padding: 0;} #menuContent a{text-decoration: none;
                                     color: #ffffff}</style>
    <style>
        .ColorRed{
            color:red
        }
        .ColorBlue{
            color:blue;
        }
    </style>

    <script type="text/javascript">
        src="/jsmin/jquery-1.4.4.min.js"
    </script>

    <script type="text/javascript">

        function init() {
            var countNumber = document.getElementById("countNumber").value;
            var sumPage = document.getElementById("sumPageNumber").value;
            var currentPage = document.getElementById("currentPage").value;

            var info = "一共" + countNumber + "条数据," + "共" + sumPage + "页,"
                + "当前第:" + currentPage + "页";

            document.getElementById("pageInfo").innerHTML= info;
        }
        function changeStatus() {
            const status = document.getElementById("indexStatus").value;
            document.getElementById("Status").value = status;
        }
        
        function toPrePage() {
            var currentPageObject = document.getElementById("currentPage");
            var currentPage = parseInt(currentPageObject.value);
            if (currentPage == 1){
                alert("数据已到顶!");
            } else {
                currentPageObject.value = currentPage - 1;
                var pageSize = parseInt(document.getElementById("pageSize").value);
                var startPageObject = document.getElementById("startPage");
                startPageObject.value = parseInt(startPageObject.value) - pageSize;
                document.getElementById("listForm").submit();
            }
        }
        
        function toNextPage() {
            var currentPageObject = document.getElementById("currentPage");
            var currentPage = parseInt(currentPageObject.value);
            var sumPage = parseInt(document.getElementById("sumPageNumber").value);
            if (currentPage >= sumPage){
                alert("数据已到顶!");
            } else {
                currentPageObject.value = currentPage + 1;
                var pageSize = parseInt(document.getElementById("pageSize").value);
                var startPageObject = document.getElementById("startPage");
                startPageObject.value = parseInt(startPageObject.value) + pageSize;
                document.getElementById("listForm").submit();
            }
        }

        function toLocationPage() {
            var pageNumber = document.getElementById("pageNumber").value;
            var currentPageObject = document.getElementById("currentPage").value;
            var currentPage = currentPageObject.value;
            if(pageNumber == null || pageNumber == "") {
                alert("请输入要跳转的页数");
            } else {
                pageNumber = parseInt(pageNumber);
                var sumPae = parseInt(document.getElementById("sumPageNumber").value);
                if(pageNumber < 1) {
                    alert("数据已到底!");
                } else if(pageNumber > sumPae) {
                    alert("数据已到顶!");
                }
            }
        }
    </script>
</head>
<body onload="init()">
<%--    <%@ include file="../menu.jsp"%>--%>
    <br/>
    <form id="listForm" action="list.action" method="post">
        姓名：<input type="text" name="Name" style="width: 120px" />
        手机：<input type="text" name="Telephone" style="width: 120px" />
        地址: <input type="text" name="Address" style="width: 120px" />
        状态: <select id="indexStatus" onchange="changeStatus()">
                <option value="-1" selected="selected">全部</option>
                <option value="1">启用</option>
                <option value="0">停用</option>
             </select>
        <input type="hidden" name="Status" id="Status" value="-1">
        创建日期: <input type="text" name="CreateTime" />
        <input type="submit" value="搜索" style="background-color: #173e65; color: #ffffff; width: 70px;">
        <br/>
        <!--显示错误信息-->
        <c:if test="${errorMsg}">
            <span style=".ColorRed">errorMsg</span>
        </c:if>

        <input type="hidden" name="startPage" id="startPage" value="${startPage}"/>
        <input type="hidden" name="currentPage" id="currentPage" value="${currentPage}"/>
        <input type="hidden" name="pageSize" id="pageSize" value="${pageSize}"/>
        <input type="hidden" name="sumPageNumber" id="sumPageNumber" value="${sumPageNumber}}"/>
        <input type="hidden" name="countNumber" id="countNumber" value="${countNumber}"/>

        <hr style="margin-top: 10px; "/>

        <c:if test="${list != null}">
            <table style="margin-top: 10px; width: 700px; text-align: center;" border = 1>
                <tr>
                    <td>序号</td><td>姓名</td><td>手机号</td><td>地址</td>
                    <td>状态</td><td>创建日期</td><td>操作</td>
                </tr>
                <c:forEach items="${list}" var="item" varStatus="status">
                    <tr>
                        <td>${status.index+1}</td>
                        <td>${item.name}</td>
                        <td>${item.telephone}</td>
                        <td>${item.address}</td>
                        <td>
                            <c:if test="${item.status==1}">
                                <span style=".ColorBlue">启用</span>
                            </c:if>
                            <c:if test="${item.status==0}">
                                <span style=".ColorRed">停用</span>
                            </c:if>
                        </td>
                        <td>${item.createTime}</td>
                        <td>
                            <a>编辑</a>|
                            <a>删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${list==null}">
            <b>搜索为空!</b>
        </c:if>
        <div style="margin-top: 10px;">
            <a onclick="toPrePage()">上一页</a>
            <a onclick="toNextPage()">下一页</a>
            <input type="text" id="pageNumber" style="width: 50px"/>
            <button onclick="toLocationPage()">go</button>
            <div id="pageInfo"></div>
        </div>
    </form>
</body>
</html>
