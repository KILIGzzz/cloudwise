<%--
  Created by IntelliJ IDEA.
  User: KILIG
  Date: 2020/12/4
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>修改用户信息</title>
    <style>
        .form {
            position: absolute;
            top: 7%;
            left: 50%;
            transform: translate(-50%);
        }
    </style>
</head>
<body>
<h1 style="text-align: center">修改用户信息</h1>
<form class="form" method="post" action="${pageContext.request.contextPath}/userServlet?method=update">
    <table border="1px">
        <caption style="color: red">${check_userName_message1}</caption>
        <tr>
            <td>用户编号</td>
            <td><input type="text" name="id" value="${updateUser.get("id")}" disabled></td>
        </tr>
        <tr>
            <td>用户账号</td>
            <td><input type="text" name="username" value="${updateUser.get("username")}"></td>
        </tr>
        <tr>
            <td>用户密码</td>
            <td><input type="text" name="password" value="${updateUser.get("password")}"></td>
        </tr>
        <tr>
            <td>手机号</td>
            <td><input type="text" name="phone" value="${updateUser.get("phone")}"></td>
        </tr>
        <tr>
            <td>部门</td>
            <td><select name="userDeptId">
                <c:forEach items="${allDept}" var="dept">
                    <option value="${dept.get("deptid")}" ${dept.get("deptid") == updateUser.get("deptid")?"selected":""}>${dept.get("dname")}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td  style="text-align: center" colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
