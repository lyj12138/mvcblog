<%@ page import="java.awt.*" %>
<%@ page import="com.blog.util.MD5" %><%--
  Created by IntelliJ IDEA.
  User: mylu
  Date: 2020/12/9
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.itcast.cn/MD5"  prefix="MD5"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/bootstrap4.0.min.css" >
    <script src="/js/jquery.slim.min.js" ></script>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/popper.min.js" ></script>
    <script src="/js/bootstrap4.0.min.js"></script>
    <script type="text/javascript" src="/js/convert.js"></script>
    <script type="text/javascript" src="/js/md5.js"></script>
    <script src="/js/layer.js"></script>
</head>
<body>
<div class="container">
    <form>
        <input type="hidden" id="id" value="${user.id}" name="id">
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="用户名" value="${MD5:convertMD5(user.username)}">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="密码" value="${user.password}">
        </div>
        <div class="form-group">
            <label for="email">邮箱</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="邮箱" value="${MD5:convertMD5(user.email)}">
        </div>
        <div class="form-group">
            <label for="nickname">昵称</label>
            <input type="text" class="form-control" id="nickname" name="nickname" placeholder="昵称" value="${user.nickname}">
        </div>
        <div class="form-group">
            <label for="state">状态</label>
            <input type="text" class="form-control" id="state" name="state" placeholder="状态" value="${user.state}">
        </div>
        <button id="changeButton"  class="btn btn-primary">修改
        </button>
    </form>
</div>
</body>
<script>
    $("#changeButton").click(function () {
            $.ajax({
                type: "POST",
                url: "/admin/user/edit/do",
                data: {
                    id:$("#id").val() ,
                    password:$.md5($("#password").val()),
                    email:convert($("#email").val()),
                    nickname:$("#nickname").val(),
                    state:$("#state").val(),
                    username:convert($("#username").val())
                },
                dataType: "json",
                success: function(data) {
                    if(data.stateCode.trim()=="1"){
                        layer.msg('修改成功!',{icon:1,time:1000});
                        setTimeout("window.location.reload()",1000);
                    }
                    else{
                        layer.msg('修改失败!',{icon:5,time:1000});
                    }
                }
            });

    })
</script>
</html>
