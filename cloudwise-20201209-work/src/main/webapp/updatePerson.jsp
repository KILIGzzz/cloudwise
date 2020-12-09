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
<head>
    <script src="${pageContext.request.contextPath}/static/jquery-1.10.2.js"></script>
    <title>修改人员信息</title>
</head>
<body>
 <%--   <%=session.getAttribute("check_personName_message")%>--%>
    <form method="post" action="${pageContext.request.contextPath}/person?method=update">
        <table border="1px">
            <tr>
                <td>人员编号</td>
                <td> <input  readonly="readonly" type="text" name="personid" value="${updatePerson.get("personid")}"></td>
            </tr>
            <tr>
                <td>人员姓名</td>
                <td>   <input type="text" name="personname" value="${updatePerson.get("personname")}" onblur="checkPersonName(this)"> <span id="aaa"></span></td>

            </tr>
            <tr>
                <td>户口所在地</td>
                <td> <select name="personareaid">
                    <c:forEach items="${allArea}" var="area">
                        <option value="${area.get("areaid")}" ${updatePerson.get("personareaid")==area.get("areaid")?'selected':''} >${area.get("areaname")}</option>
                    </c:forEach>
                </select> </td>
            </tr>
            <tr>
                <td>人员年龄</td>
                <td>   <input type="text" name="personage" value="${updatePerson.get("personage")}"></td>
            </tr>
            <tr>
                <td>家庭住址</td>
                <td>     <input type="text" name="personaddress" value="${updatePerson.get("personaddress")}"></td>
            </tr>
        </table>

        <input type="submit" value="更新">
        <input type="reset" value="重置">
    </form>
</body>
    <script>
     /*   function createXHR(){
            try {
                return new XMLHttpRequest();
            } catch (e) {
                return new ActiveXObject("Microsoft.XMLHTTP");
            }
        }*/
        /*function checkPersonName(object) {

            //将value异步发送到servlet中校验合法性
            var xhr=createXHR();
            //xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhr.open("GET","${pageContext.request.contextPath}/person?method=checkPersonName&personname="+object.value,true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        var obj = document.getElementById("aaa");
                        obj.innerHTML = xhr.responseText;
                    } else {
                        alert("AJAX服务器返回错误！");
                    }
                }
            }
            xhr.send(null);
        }*/

     function checkPersonName(object){
         //使用jquery发送ajax请求
         $.ajax({
             url:"${pageContext.request.contextPath}/person?method=checkPersonName&personname="+object.value,//请求的后台servlet路径？
            // data:{},//传递给后台的参数post
             dataType:"json",//相应的数据类型：服务器给我的
             type:"get",//前端发送请求的方式
              async:false,//ajax请求时异步true，，同步是false
             success:function (xxx) {//相当于onreadystatechange
                 //成功的响应函数  ：xxx名字随便写，代表的是服务器相应的内容
                 alert(xxx.message);
             }
         })
     }
    </script>
</html>
