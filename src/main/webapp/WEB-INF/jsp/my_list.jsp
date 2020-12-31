<%--
  Created by IntelliJ IDEA.
  User: mylu
  Date: 2020/12/9
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                        <a class="dropdown-item" href="javascript:void(0);" onclick="fullScreen('添加文章','/admin/article/add')">文章</a>
                    </div>
                </div>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/user/main">主页 </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/user/article/list">文章管理</a>

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
        <form class="form-inline my-2 my-lg-0" action="/user/article/search" method="GET">
            <input class="form-control mr-sm-2" type="search" placeholder="文章标题或内容..." aria-label="Search" name="word">
            <button class="btn btn-outline-success my-2 my-sm-0 btn-sm" type="submit">搜索</button>
        </form>

        <a class="btn btn-outline-danger btn-sm" href="/user/logout" role="button">退出</a>
    </div>
</nav>
<br/>
<table class="table table-sm">
    <thead>
    <tr class="table-info">
        <th>id</th>
        <th width="25%">标题</th>
        <th>发表时间</th>
        <th>点击量</th>
        <th>详情</th>
        <th>评论</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${articles}" var="article">
        <tr>
            <th scope="row">${article.id}</th>
            <td>${article.title}</td>
            <td>${article.localTime}</td>
            <td>${article.click}</td>
            <td><button type="button" class="btn btn-outline-info btn-sm" onclick="fullScreen('《${article.title}》','/admin/article/detail?id=${article.id}')">详情</button></td>
            <td><button type="button" class="btn btn-outline-success btn-sm" onclick="fullScreen('《${article.title}》|评论管理','/user/article/comment?id=${article.id}')">评论</button></td>
            <td><button type="button" class="btn btn-outline-primary btn-sm" onclick="fullScreen('《${article.title}》|编辑','/admin/article/edit?id=${article.id}')">编辑</button>&nbsp;&nbsp;</td>
            <td><button type="button" class="btn btn-outline-danger btn-sm" onclick="ifdelete('${article.id}','${article.title}') ">删除</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example" style="position: absolute;bottom: 10px;left: 42%">
    <ul class="pagination justify-content-center">
        <li class="page-item  <c:if test="${pageInfo.pageNum==1}">disabled</c:if> ">
            <a class="page-link" <c:if test="${empty word}">href="/user/article/list?page=1"</c:if><c:if test="${!empty word}">href="/user/article/search?page=1&word=${word}"</c:if> >&laquo;</a>
        </li>
        <c:forEach begin="1" end="${pageInfo.pages}" step="1" var="pageNo">
        <li class="page-item <c:if test="${pageInfo.pageNum==pageNo}">active</c:if>"><a class="page-link" <c:if test="${empty word}">href="/user/article/list?page=${pageNo}"</c:if> <c:if test="${!empty word}">href="/user/article/search?page=${pageNo}&word=${word}"</c:if> >${pageNo}</a></li>
        </c:forEach>
        <li class="page-item  <c:if test="${pageInfo.pageNum==pageInfo.pages}">disabled</c:if> ">
            <a class="page-link" <c:if test="${empty word}">href="/user/article/list?page=${pageInfo.pages}"</c:if><c:if test="${! empty word}">href="/user/article/search?page=${pageInfo.pages}&word=${word}"</c:if>>&raquo;</a>
        </li>
    </ul>
</nav>
<script src="/js/jquery-3.2.1.min.js"></script>
<script>
    function fullScreen(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            area: ['70%', '70%'],
            content: url,
            maxmin: true,
            end: function(){
                //location.replace("/user/article/list");
                location.reload();
            }
        });
        layer.full(index);
    }

    function ifdelete(id,title) {
        layer.confirm('确定删除该文章吗?', {
            btn: ['确定','取消']
        }, function(){
            $.ajax({
                type: 'POST',
                url: '/api/article/del',
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
