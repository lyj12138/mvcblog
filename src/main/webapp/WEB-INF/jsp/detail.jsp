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
    <script src="/js/layer.js"></script>
    <link rel="stylesheet" href="/css/article.css">
</head>
<body background="/img/bg.png" >

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
                    <img src="/img/me.jpg" width="200px" height="200px" >
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
            <time id="time1">${article.localTime}</time>
            <h2 style="text-align: center; ">${article.title}</h2>
            <p style="position: center" class="text-info">点击量:${article.click}</p>
            <section>
                <blockquote>
                    <p>${article.desci}</p>
                </blockquote>
                <p id="zhengwen">
                    ${article.content}
                </p>
                <p style="text-align:center;color:#ccc;font-size:12px;margin-top:40px;">
                    But are we all lost stars
                    <br>
                    trying to light up the world?
                </p>
                <p style="margin: 5em 0 1em;text-align: center;color: #83b8ec;font-size: .8em">
                    <span>Happy Everyday</span>
                </p>
            </section>
        </article>
    </div>
    <% int i =1;    %>
    <c:forEach items="${comments}" var="comment">


        <article class="comment" id="comment_${comment.id},floor_<%= i%>">
            <c:if test="${ comment.reference!=0}">
            <section style="text-align:left;color:gray">
                回复${comment.floor}楼&nbsp;&nbsp;${comments[comment.floor-1].nickname}&nbsp;&nbsp;${comments[comment.floor-1].date}<br/><br/>
                <p>${comments[comment.floor-1].content}</p><br/>
            </section>
            </c:if>
                <section style="text-align:left">
                <%= i++  %>楼&nbsp;&nbsp;${comment.nickname}&nbsp;&nbsp;${comment.date}<br/><br/>
                <p>${comment.content}</p><br/>
                </section>
            </article>
    </c:forEach>
    		<div  class="form-horizontal" role="form" style="margin:10px">
    			<div class="form-group">
                    <label id="tent" class="col-sm-2 control-label">评论</label>
                        <div class="col-sm-3">
                               <textarea id="content"  class="form-control" rows="3"  placeholder="文明上网，理性发言" ></textarea>
                         </div>
                 </div>
               <input id="articleId" type="hidden" value="${article.id}" >
                <input id="reference" type="hidden" name="reference" value="0">
                <input id="floor" type="hidden" name="floor" value="0">

                        <div class="form-group" style="position:relative;left:13%">
     <br/>
        <p style="text-align: right;color: red;position: absolute" id="info"></p>
        <br/>
     <button id="commentButton" class="btn btn-default" type="submit">提交</button>
                                                </div>
    			</div>
    <script>
        $('article').each(function(){
            $(this).click(function(){
                    str=$(this).attr('id');
                    str=str.replace("comment_","");
                    str=str.replace("floor_","");
                    var arr=new Array();
                     arr=str.split(",");
                    if(arr[0]===$("#reference").val())
                    {
                        layer.confirm('确定取消回复该条评论吗?', {
                            btn: ['确定','取消']
                        }, function(){
                            //var url="/article?id=${article.id}";
                            //location.replace(url)
                            $("#reference").attr('value','0')
                            $("#floor").attr('value','0')
                            $("#tent").html("评论")
                            layer.closeAll('dialog')

                        }, function(){

                        });
                    }
                else{
                        layer.confirm('确定回复该条评论吗?', {
                            btn: ['确定','取消']
                        }, function(){
                            //var url="/article?id=${article.id}&reference="+arr[0]+"&floor="+arr[1];
                            //location.replace(url)
                            $("#reference").attr('value',arr[0])
                            $("#floor").attr('value',arr[1])
                            $("#tent").html("回复第"+arr[1]+"楼")
                            layer.closeAll('dialog')




                        }, function(){
                        });
                    }
                }
            )
        })
                        $("#commentButton").click(function () {
                            if(${empty sessionScope.user['id']})
                            {
                                $("#info").text("提示:请登录后评论");
                            }
                            else if(${sessionScope.user['state']=="未激活"})
                            {
                                $("#info").text("提示:请等待审核通过");
                            }
                            else if ($("#content").val()==''){
                                $("#info").text("提示:请输入评论内容");
                            }
                            else {
                             $("#info").text("");
                                $.ajax({
                                    type: "POST",
                                    url: "/api/comment/add",
                                    data: {
                                        reference: $("#reference").val(),
                                       floor: $("#floor").val(),
                                        articleId:$("#articleId").val(),
                                        content:$("#content").val()
                                    },
                                    dataType: "json",
                                    success: function(data) {
                                        if(data.stateCode.trim() == "1") {
                                            $("#info").text("评论成功,跳转中...");
                                            window.location.reload();
                                        } else  {
                                            $("#info").text("评论失败...");
                                        }
                                    }
                                });
                            }
                        })

                    </script>
    <div style="position: relative;left: 12%">
        <c:if test="${!empty lastArticle }">
            <div ><a href="/article/?id=${lastArticle.id}"><h4><span class="label label-primary">上一篇:${lastArticle.title}</span></h4></a></div>
        </c:if>
        <c:if test="${!empty nextArticle }">
            <div><a href="/article/?id=${nextArticle.id}"><h4><span class="label label-success">下一篇:${nextArticle.title}</span></h4></a></div>
        </c:if>
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