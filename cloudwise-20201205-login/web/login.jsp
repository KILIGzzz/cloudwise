<%--
  Created by IntelliJ IDEA.
  User: KILIG
  Date: 2020/12/4
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <style>
        .form{
            position: absolute;
            width: 30%;
            top: 7%;
            left: 50%;
            transform: translate(-25%);
        }
    </style>
</head>
<body>
<h1 style="text-align: center">用户登录页面</h1>
    <form class="form" method="post" action="${pageContext.request.contextPath}/loginServlet">
        <table>
            <caption style="color: red">${msg}</caption>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
</body>
</html>
