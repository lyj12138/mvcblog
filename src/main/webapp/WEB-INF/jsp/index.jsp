<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>迷失的路</title>
    <link rel="shortcut icon" type="image/x-icon" href="/img/web-icon.png" media="screen" />
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/article.css">
</head>
<body background="img/bg.png" >

<div>
    <header id="header">
        <nav>
            <ul>
                <li>
                    <a href="/">首页</a>
                    <a href="/about">关于</a>
                    <a <c:if test="${! empty sessionScope.user['id']}">href="/user/logout"</c:if><c:if test="${empty sessionScope.user['id']}">href="/user/login"</c:if>><c:if test="${! empty sessionScope.user['id']}">退出</c:if>登录</a>
                    <a <c:if test="${! empty sessionScope.user['id']}">href="/user/main"</c:if><c:if test="${empty sessionScope.user['id']}">href="/user/login"</c:if>>我的博客</a>
                </li>
            </ul>
            <div class="my-info" onmouseover="hiddeewm()" onmouseout="hiddeewm()">
                <figure></figure>
                <span>but are we all lost stars?</span>
                <div id="hiddenewm" hidden="true" >
                    <img src="img/me.jpg" width="200px" height="200px" >
                    <p></p>
                </div>
            </div>
        </nav>
    </header>
    <div id="bg" >
        <p>
            <em>岁月易逝</em>
            <br>
            <em>人生如白驹过隙</em>
        </p>
    </div>
</div>
<div id="container">
<c:forEach items="${articles}" var="article">
    <article class="article">
        <time>${article.localTime}</time>
        <h2 class="title"><a href="article?id=${article.id}">${article.title}</a></h2>
        <span><i>${article.keywords}</i></span>
        <section class="article-content markdown-body">
            <blockquote>
                <p>${article.desci}</p>
            </blockquote>
            ......
        </section>
        <footer>
            <a href="article?id=${article.id}">阅读全文</a>
        </footer>
    </article>
</c:forEach>
        <div style="text-align: center">
            <ul class="pagination" >
                <li <c:if test="${pageInfo.pageNum==1}">class="disabled"</c:if>><a href="/?page=1">&laquo;</a></li>
                <c:forEach begin="1" end="${pageInfo.pages}" step="1" var="pageNo">
                    <li <c:if test="${pageInfo.pageNum==pageNo}">class="active"</c:if>><a href="/?page=${pageNo}">${pageNo}</a></li>
                </c:forEach>
                <li <c:if test="${pageInfo.pageNum==pageInfo.pages}">class="disabled"</c:if>><a href="/?page=${pageInfo.pages}">&raquo;</a></li>
            </ul>
        </div>
</div>
    <footer id="footer">
        <section id="copyright">
            <p style="font-size: 20px">
                © 2020 <a href="/">迷失的路</a>
            </p>
        </section>
    </footer>
</body>
</html>