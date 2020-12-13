<%--
  Created by IntelliJ IDEA.
  User: KILIG
  Date: 2020/12/11
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有人员信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/static/jquery-3.4.1/jquery-3.4.1.js"></script>
    <style>
        .form {
            width: 40%;
            height: 5%;
            float: left;
        }

        #div1 {
            float: left;
        }

        #div2 {
            float: right;
        }

        #div3 {
            float: left;
        }

        #div4 {
            float: right;
        }
    </style>
</head>
<body>
<table id="demo" lay-filter="test">
</table>
<div style="width: 90%">
    <form class="form" method="post" action="${pageContext.request.contextPath}/emp/findByCondition.do">
        <div id="div3">
            <div id="div1">
                <label class="layui-form-label">人员编号</label>
                <div class="layui-input-block">
                    <input id="empno" type="text" name="empno" placeholder="请输入人员编号"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div id="div2">
                <label class="layui-form-label">人员姓名</label>
                <div class="layui-input-block">
                    <input id="ename" type="text" name="ename"  placeholder="请输入人员姓名"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div id="div4">
            <input type="submit" class="layui-btn layui-btn layui-btn-normal" value="查询">
        </div>
    </form>
    <div style="margin-left: 45%">
        <a href="${pageContext.request.contextPath}/emp/toAdd.do">
            <button class="layui-btn layui-btn layui-btn-normal" lay-event="add">添加</button>
        </a>
    </div>
</div>
</body>
<%--按钮--%>
<script type="text/html" id="bar">
    <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
    <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delete">删除</button>
</script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#demo'
            , height: 400
            , url: '${pageContext.request.contextPath}/emp/findAll.do?empno=${empno}&ename=${ename}' //数据接口
            , page: true //开启分页
            , limit: 5
            , limits: [5, 10, 15, 20, 25, 30]
            , toolbar: true
            , cols: [[ //表头
                {field: 'empno', title: '人员编号', width: 100, sort: true}
                , {field: 'ename', title: '人员姓名', width: 120}
                , {field: 'job', title: '人员工作', width: 160, sort: true}
                , {field: 'mgr', title: '人员上级', width: 100}
                , {field: 'hiredate', title: '人员入职日期', width: 200}
                , {field: 'sal', title: '人员工资', width: 120}
                , {field: 'comm', title: '人员奖金', width: 120}
                , {field: 'dname', title: '人员部门', width: 120}
                //添加按钮
                , {field: '', title: '操作', width: 135, toolbar: "#bar"}
            ]]
        });

        //监听工具条
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
            if (layEvent === 'delete') { //删除
                layer.confirm('真的删除行么', function (index) {
                    //向服务端发送删除指令
                    $.post('${pageContext.request.contextPath}/emp/delete.do', data)
                    window.location.href = "${pageContext.request.contextPath}/index.jsp"
                });
            } else if (layEvent === 'update') { //编辑
                //do something
                $.post('${pageContext.request.contextPath}/emp/toUpdate.do', data, function () {
                        window.location.href = "${pageContext.request.contextPath}/pages/update.jsp"
                    }
                )
            }
        });
    });


</script>
</html>
