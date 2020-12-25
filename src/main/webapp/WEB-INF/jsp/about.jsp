<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>迷失的路</title>
    <link rel="shortcut icon" type="image/x-icon" href="/img/web-icon.png" media="screen" />
    <link rel="stylesheet" href="/css/about.css">
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
    <div id="container">
        <article class="article">
            <p>
                <br><br><br><br>
            <h3>我怀念的</h3>
            <br><br>
            <h3>邮箱:<a href="mailto:290162743@qq.com">290162743@qq.com</a></h3>
            <br><br><br><br>
            </p>
        </article>
    </div>
</div>
<footer id="footer">
    <section id="copyright">
        <p style="font-size: 20px">
            © 2020 <a href="/">迷失的路</a>
        </p>
    </section>
</footer>
</div>
</div>
</body>
</html>