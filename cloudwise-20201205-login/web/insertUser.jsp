<%--
  Created by IntelliJ IDEA.
  User: KILIG
  Date: 2020/12/4
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>添加人员信息</title>
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
    <h1 style="text-align: center">添加用户信息</h1>
    <form class="form" method="post" action="${pageContext.request.contextPath}/userServlet?method=add">
        <table border="1px">
            <caption style="color: red">${check_userName_message}</caption>
            <tr>
                <td>用户账号</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>用户密码</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td>手机号</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>部门</td>
                <td><select name="userDeptId">
                    <c:forEach items="${allDept}" var="dept">
                        <option value="${dept.get("deptid")}">${dept.get("dname")}</option>
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
