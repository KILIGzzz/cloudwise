<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/19
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <title>测试layui</title>
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
        ,url: '${pageContext.request.contextPath}/person?method=layui' //数据接口
        ,page: true //开启分页
        ,limit:5
        ,limits:[5,10,15,20,25,30]
        ,toolbar:true
        ,cols: [[ //表头
          {field: 'personid', title: '人员编号', width:80, sort: true}
          ,{field: 'personname', title: '用户姓名', width:120}
          ,{field: 'areaname', title: '人员户口所在地', width:160, sort: true}
          ,{field: 'personage', title: '人员年龄', width:100}
          ,{field: 'personaddress', title: '人员家庭住址', width: 200}
        ]]
      });

    });
  </script>
</html>
