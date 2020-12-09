<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/19
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>安居户籍管理系统</h1>
<table border="1px">
    <thead style="background-color: aqua">
    <tr>
        <td>
            人员编号
        </td>
        <td>
            人员姓名
        </td>
        <td>
            人员户口所在地
        </td>
        <td>
            人员年龄
        </td>
        <td>
            人员家庭住址
        </td>
        <td colspan="2">
            操作
        </td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allPerson}" var="person">
        <tr>
            <td>${person.get("personid")}</td>
            <td>${person.get("personname")}</td>
            <td>${person.get("areaname")}</td>
            <td>${person.get("personage")}</td>
            <td>${person.get("personaddress")}</td>
            <td><a href="${pageContext.request.contextPath}/person?method=toUpdate&personid=${person.get("personid")}">编辑</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/person?method=delete&personid=${person.get("personid")}">删除</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
    共<span>${pageBean.count}</span>条，共<span>${pageBean.pageTotal}</span>页
    <a href="${pageContext.request.contextPath}/person?pageNo=1&pageSize=${pageBean.pageSize}">首页</a>
    <a  href="${pageContext.request.contextPath}/person?pageNo=${pageBean.pageNo-1}&pageSize=${pageBean.pageSize}"  <c:if test="${pageBean.pageNo==1}">hidden</c:if> >上一页</a>
    <a href="${pageContext.request.contextPath}/person?pageNo=${pageBean.pageNo+1}&pageSize=${pageBean.pageSize}" <c:if test="${pageBean.pageNo==pageBean.pageTotal}">hidden</c:if> >下一页</a>
    <a href="${pageContext.request.contextPath}/person?pageNo=${pageBean.pageTotal}&pageSize=${pageBean.pageSize}">末页</a>
    <form action="${pageContext.request.contextPath}/person" style="display: inline-block">
        当前第<input type="text" name="pageNo" value="${pageBean.pageNo}" style="width: 20px">页
        一页显示<input type="text" name="pageSize" value="${pageBean.pageSize}" style="width: 20px">行
        <input type="submit" value="GO">
    </form>

</body>
<head>
    <title>显示所有的人员信息</title>
</head>
</html>
