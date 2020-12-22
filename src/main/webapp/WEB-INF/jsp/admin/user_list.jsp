<%--
  Created by IntelliJ IDEA.
  User: mylu
  Date: 2020/12/9
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.itcast.cn/MD5"  prefix="MD5"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="/css/bootstrap4.0.min.css" >
    <script src="/js/jquery.slim.min.js" ></script>
    <script src="/js/popper.min.js" ></script>
    <script src="/js/bootstrap4.0.min.js"></script>
    <script src="/js/layer.js"></script>
</head>
<body>
<br/>
<table class="table table-sm">
    <thead>
    <tr class="table-info">
        <th>id</th>
        <th>用户名</th>
        <th>邮箱</th>
        <th>昵称</th>
        <th>状态</th>
        <th>状态变更</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <th scope="row">${user.id}</th>
            <td>${MD5:convertMD5(user.username)}</td>
            <td>${MD5:convertMD5(user.email)}</td>
            <td>${user.nickname}</td>
            <td>${user.state}</td>
            <td><button type="button" class="btn btn-outline-primary btn-sm" onclick="fullScreen('${sessionScope.flag}','/admin/user/edit?id=${user.id}')">状态变更</button>&nbsp;&nbsp;</td>
            <td><button type="button" class="btn btn-outline-danger btn-sm" onclick="ifdelete('${user.id}')">删除</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example" style="position: absolute;bottom: 10px;left: 42%">
    <ul class="pagination justify-content-center">
        <li class="page-item  <c:if test="${pageInfo.pageNum==1}">disabled</c:if> ">
            <a class="page-link" href="/admin/user/list?page=1" >&laquo;</a>
        </li>
        <c:forEach begin="1" end="${pageInfo.pages}" step="1" var="pageNo">
            <li class="page-item <c:if test="${pageInfo.pageNum==pageNo}">active</c:if>"><a class="page-link" href="/admin/user/list?page=${pageNo}">${pageNo}</a></li>
        </c:forEach>
        <li class="page-item  <c:if test="${pageInfo.pageNum==pageInfo.pages}">disabled</c:if> ">
            <a class="page-link" href="/admin/user/list?page=${pageInfo.pages}">&raquo;</a>
        </li>
    </ul>
</nav>
<script src="/js/jquery-3.2.1.min.js"></script>
<script>
    function fullScreen(flag,url){
        var title="用户信息"
        var index = layer.open({
            type: 2,
            title:title,
            area: ['70%', '70%'],
            content: url,
            maxmin: true,
            end: function(){
                if(flag=="1")
                location.replace("/admin/user/state");
                else
                location.replace("/admin/user/list");

            }
        });
        layer.full(index);
    }
     function test() {
         alert(1)
     }
    function ifdelete(id) {
        layer.confirm('确定删除该用户吗?', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $.ajax({
                type: 'POST',
                url: '/admin/user/del',
                datatype:'json',
                data:{"id":id},
                success: function(data){
                    if(data['stateCode']==1){
                        layer.msg('删除成功!',{icon:1,time:1000});
                        setTimeout("window.location.reload()",1000);
                    }
                    else {
                        layer.msg('删除失败!',{icon:5,time:1000});
                    }
                },
                error:function(data) {
                    console.log('错误...');
                },
            });
        }, function(){

        });
    }

</script>
</body>
</html>
