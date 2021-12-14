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
        .c{
            border-style: solid;width: 200px;height: 130px;
            margin: 4px 23px 0px 23px;border-radius:5px;display:block;
            background:#fff;
            margin:10% auto;
        }
        .mask,.addMask{
            width:100%;
            height:100%;
            position: absolute;
            background:rgba(0,0,0,.3);
            display: none;
        }
    </style>

    <
</head>
<body onload="init()">
<%--    <%@ include file="../menu.jsp"%>--%>
    <br/>

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

    function editRetailer(id){
        var message = "{\'id\':\'" + id + "\'}"
        alert(message)
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/retailer/queryRetailerById.action',
            contentType:'application/json;charset=utf-8',
            data:message,//数据格式是json串
            success:function(data){//返回json结果
                $("#editName").val(data["name"]);
                $("#editTelphone").val(data["telphone"]);
                $("#editAddress").val(data["address"]);
                $("#retailerId").val(data["retailerId"]);
                $("#editStatus").val(data["status"]);
                $("#eStatus").val(data["status"]);
                //显示弹出框
                $(".mask").css("display","block");
                //引入分页信息至该form表单
                $("#eStartPage").val($("#startPage").val());
                $("#eCurrentPage").val($("#currentPage").val());
                $("#ePageSize").val($("#pageSize").val());
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
                alert(message);
            }
        });
    }

    function cancelEdit(){
        $(".mask").css("display","none");
    }

    function changeEditStatus(){
        var status = document.getElementById("editStatus").value;
        document.getElementById("eStatus").value=status;
    }

    </script>

    <div class="mask">
       <div class="c">
           <div style="background-color:#173e65;height:20px;color:#fff;font-size:12px;padding-left:7px;">
            修改信息<font style="float:right;padding-right: 10px;" onclick="cancelEdit()">x</font>
           </div>
                <form id="editForm" action="queryRetailerById.action" method="post">
                    姓名：<input type="text" id="editName" name="name" style="width:120px"/> <br/>
                    手机：<input type="text" id="editTelphone" name="telphone" style="width:120px"/><br/>
                    地址：<input type="text" id="editAddress" name="address" style="width:120px"/><br/>
                    状态：<select id="eStatus" onchange="changeEditStatus()">
                    <option value="1">启用</option>
                    <option value="0">停用</option>
                </select><br/>
                    <input type="hidden" name="retailerId" id="retailerId"/>
                    <input type="hidden" name="status" id="editStatus"/>
                    <input type="hidden" name="startPage" id="eStartPage"/>
                    <input type="hidden" name="currentPage" id="eCurrentPage"/>
                    <input type="hidden" name="pageSize" id="ePageSize"/>
                    <input type="submit" value="提交" style="background-color:#173e65;color:#ffffff;width:70px;"/>
                </form>
            </div>
      </div>

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
                            <a onclick="editRetailer('${item.retailerId}')">编辑</a>|
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
