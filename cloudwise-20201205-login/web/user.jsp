<%--
  Created by IntelliJ IDEA.
  User: KILIG
  Date: 2020/12/4
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>显示所有用户信息</title>
    <style>
        .table {
            position: absolute;
            width: 29%;
            top: 7%;
            left: 50%;
            transform: translate(-50%);
        }
    </style>
</head>
<body>
    <h1 style="text-align: center">用户信息管理系统</h1>
    <table class="table" border="1px">
        <caption style="color: green">${usernameInfo}</caption>
        <thead style="background-color: aqua">
        <tr>
            <td>
                用户编号
            </td>
            <td>
                用户账号
            </td>
            <td>
                手机号
            </td>
            <td>
                部门
            </td>
            <td>
                创建时间
            </td>
            <td colspan="2">
                操作
            </td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allUser}" var="user">
            <tr>
                <td>${user.get("id")}</td>
                <td>${user.get("username")}</td>
                <td>${user.get("phone")}</td>
                <td>${user.get("deptid")}</td>
                <td>${user.get("createtime")}</td>
                <td><a href="${pageContext.request.contextPath}/userServlet?method=toUpdate&id=${user.get("id")}">编辑</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/userServlet?method=delete&id=${user.get("id")}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <td colspan="7" style="text-align: center"><a
                href="${pageContext.request.contextPath}/userServlet?method=toAdd">添加</a></td>

        </tbody>
    </table>

</body>
</html>
