<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KILIG
  Date: 2020/12/11
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改人员信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <style>
        .div1{
            margin-top: 2%;
            width: 30%;
        }
    </style>
</head>
<body>
<div class="div1">
    <form class="layui-form" action="${pageContext.request.contextPath}/emp/update.do">
        <div class="layui-form-item">
            <label class="layui-form-label">人员编号</label>
            <div class="layui-input-block">
                <input type="text" name="empno" required  lay-verify="required" readonly value="${emp.empno}" placeholder=""  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">人员姓名</label>
            <div class="layui-input-block">
                <input type="text" name="ename" required  lay-verify="required" value="${emp.ename}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">人员工作</label>
            <div class="layui-input-block">
                <select name="job" lay-verify="required">
                    <c:forEach items="${jobs}" var="job">
                        <option value="${job}" ${job == emp.job?"selected":""}>${job}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">人员上级</label>
            <div class="layui-input-block">
                <input type="text" name="mgr" required  lay-verify="required" value="${emp.mgr}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <%--    无用值--%>
        <input type="hidden" name="hiredate" value="aaa">
        <div class="layui-form-item">
            <label class="layui-form-label">人员工资</label>
            <div class="layui-input-block">
                <input type="text" name="sal" required  lay-verify="required" value="${emp.sal}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">人员奖金</label>
            <div class="layui-input-block">
                <input type="text" name="comm" required  lay-verify="required" value="${emp.comm}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">人员部门</label>
            <div class="layui-input-block">
                <select name="deptno" lay-verify="required">
                    <c:forEach items="${depts}" var="dept">
                        <option value="${dept.deptid}" ${dept.deptid == emp.deptno?"selected":""}>${dept.dname}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        // //监听提交
        // form.on('submit(formDemo)', function(data){
        //     layer.msg(JSON.stringify(data.field));
        //     return false;
        // });
    });
</script>

</body>
</html>
