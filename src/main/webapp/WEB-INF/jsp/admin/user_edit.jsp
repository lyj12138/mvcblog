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
            <input type="hidden" class="form-control" id="password" name="password" placeholder="密码" value="${user.password}">
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
<script src="http://passport.cnblogs.com/scripts/jsencrypt.min.js"></script>
<script>
    $("#changeButton").click(function () {
        $.ajax({
            url: "/api/getRSA",
            type: "GET",
            dataType: "json",
            async: false,
            success: function (res) {
                var encrypt = new JSEncrypt();
                if (res) {
                    var publicKey = null;
                    publicKey = res.publicKey;
                    var id;
                    var username;
                    var email;
                    encrypt.setPublicKey(publicKey);
                    id = encrypt.encrypt($("#id").val());
                    username = encrypt.encrypt($("#username").val());
                    email = encrypt.encrypt($("#email").val())
                    $.ajax({
                        type: "POST",
                        url: "/admin/user/edit/do",
                        data: {
                            id: id,
                            password: $("#password").val(),
                            email: email,
                            nickname: $("#nickname").val(),
                            state: $("#state").val(),
                            username: username
                        },
                        dataType: "json",
                        success: function (data) {

                        }
                    });
                }
            }
        });
        alert("修改成功")
        window.location.reload();
    })
</script>
</html>
