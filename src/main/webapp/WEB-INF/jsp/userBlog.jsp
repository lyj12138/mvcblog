<%--
  Created by IntelliJ IDEA.
  User: mylu
  Date: 2020/12/9
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.itcast.cn/MD5"  prefix="MD5"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的博客系统</title>
    <link rel="stylesheet" href="/css/bootstrap4.0.min.css" >
    <script src="/js/jquery.slim.min.js" ></script>
    <script src="/js/popper.min.js" ></script>
    <script src="/js/bootstrap4.0.min.js"></script>
    <script src="/js/layer.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand text-success" href="/user/main">我的博客管理</a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="/">首页</a>
            </li>
            <li clas="nav-item">
                <a class="nav-link" href="/about">关于</a>
            </li>
            <li class="nav-item">
                <div class="btn-group">
                    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        新建
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="javascript:void(0);" <c:if test="${sessionScope.user['state']!='未激活'}">onclick="fullScreen('添加文章','/admin/article/add')"</c:if>>文章</a>
                    </div>
                </div>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/user/main">主页 </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" <c:if test="${sessionScope.user['state']!='未激活'}"> href="/user/article/list"</c:if>>文章管理</a>
            </li>
            <li class="nav-item">
                <div class="btn-group">
                    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        评论
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="javascript:void(0);" <c:if test="${sessionScope.user['state']!='未激活'}">onclick="fullScreen('我的回复','/user/comment')"</c:if>>我的回复</a>
                        <a class="dropdown-item" href="javascript:void(0);" <c:if test="${sessionScope.user['state']!='未激活'}">onclick="fullScreen('回复我的','/user/comment/reply')"</c:if>>回复我的</a>
                    </div>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" <c:if test="${sessionScope.user['state']!='未激活'}">action="/user/article/search"</c:if> method="GET">
            <input class="form-control mr-sm-2" type="search" placeholder="文章标题或内容..." aria-label="Search" name="word">
            <button class="btn btn-outline-success my-2 my-sm-0 btn-sm" type="submit">搜索</button>
        </form>

        <a class="btn btn-outline-danger btn-sm" href="/user/logout" role="button">退出</a>
    </div>
</nav>
<div class="card mb-3">
    <div style="height: 180px;overflow: hidden">
        <img class="card-img-top" src="/img/4.jpg" alt="Card image cap" style="height: 100%;width:100%;">
    </div>

    <div class="card-body">
        <h4 class="card-title">${MD5:convertMD5(user.username)}<c:if test="${sessionScope.user['state']=='未激活'}">(审核暂未通过请耐心等待)</c:if></h4>
    </div>
</div>
<div >
    <table class="table table-hover">
        <p class="text-success" style="text-align: center"> 系统统计</p>
        <thead>
        <tr >
            <th>#</th>
            <th>文章数</th>
        </tr>
        </thead>
        <tbody>
        <tr class="table-success">
            <th scope="row">全部</th>
            <td>${articleCount}</td>
        </tr>
        </tbody>
    </table>
</div>


<script>
    function fullScreen(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            area: ['70%', '70%'],
            content: url,
            maxmin: true,
            end:function(){
                location.replace("/user/main");
            }
        });
        layer.full(index);
    }
</script>
</body>
</html>
