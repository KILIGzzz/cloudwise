<%--
  Created by IntelliJ IDEA.
  User: KILIG
  Date: 2020/12/8
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>

</head>
<body>
<table id="demo" lay-filter="test"></table>
</body>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 400
            ,url: '${pageContext.request.contextPath}/userServlet' //数据接口
            ,page: true //开启分页
            ,limit:5
            ,limits:[5,10,15,20,25,30]
            ,toolbar:true
            ,cols: [[ //表头
                {field: 'EMPNO', title: '人员编号', width:80, sort: true}
                ,{field: 'ENAME', title: '人员姓名', width:120}
                ,{field: 'JOB', title: '人员工作', width:160, sort: true}
                ,{field: 'MGR', title: '人员上级', width:100}
                ,{field: 'HIREDATE', title: '人员入职日期', width: 200}
                ,{field: 'SAL', title: '人员工资', width: 120}
                ,{field: 'COMM', title: '人员奖金', width: 120}
                ,{field: 'dname', title: '人员部门', width: 120}
            ]]
        });
    });
</script>
</html>
