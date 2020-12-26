<%--
  Created by IntelliJ IDEA.
  User: mylu
  Date: 2020/12/26
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.itcast.cn/MD5"  prefix="MD5"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>博客管理系统</title>
    <link rel="stylesheet" href="/css/bootstrap4.0.min.css" >
    <script src="/js/jquery.slim.min.js" ></script>
    <script src="/js/popper.min.js" ></script>
    <script src="/js/bootstrap4.0.min.js"></script>
    <script src="/js/layer.js"></script>
</head>
<body>
<div class="container">
    <c:if test="${!empty comments}">
        <table class="table">
            <thead class="thead-default">
            <tr>

                <th>回复昵称</th>
                <th>评论内容</th>
                <th>回复内容</th>
                <th>日期</th>
                <th>回复</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${comments}" var="comment">
                <%  int flag=1;%>
                <% int i =1;    %>
                <tr>
                    <td>${comment.nickname}</td>
                    <c:forEach items="${allComments}" var="allComment">
                        <c:if test="${allComment.id==comment.reference}">
                            <td>${allComment.content}</td>
                            <% flag=0;%>
                            <% i++;%>
                        </c:if>
                        <c:if test="${allComment.articleId==comment.articleId}">
                        <c:if test="<%=flag==1%>">
                            <% i++;%>
                        </c:if>
                        </c:if>
                    </c:forEach>
                    <td>${comment.content}</td>
                    <td>${comment.date}</td>
                    <td><button type="button" class="btn btn-outline-danger btn-sm" onclick="ifcomment('${comment.nickname}','${comment.id}','${comment.articleId}',<%=i%>) ">回复</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div id="com" style="display: none">
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
                    <button id="commentButton" class="btn btn-outline-danger btn-sm" onclick="doComment()">回复</button>
                    <button id="Button" class="btn btn-outline-danger btn-sm" onclick="cancelComment()">取消回复</button>
                </div>
            </div>
        </div>

        <script src="/js/jquery-3.2.1.min.js"></script>
        <script>
            function ifcomment(nickname,reference,articleId,i){
                $("#com").attr('style','');
                $("#tent").html("回复"+nickname+":");
                $("#reference").attr('value',reference)
                $("#floor").attr('value',i)
                $("#articleId").attr('value',articleId)
            }
            function cancelComment() {
                $("#com").attr('style','display:none');
            }
            function doComment() {

                if ($("#content").val()==''){
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
                                setTimeout("window.location.reload()",1000);
                            } else  {
                                $("#info").text("评论失败...");
                            }
                        }
                    });
                }
            }
        </script>
    </c:if>
    <c:if test="${empty comments}">
        <div class="card">
            <div class="card-body">
                该文章暂无评论!
            </div>
        </div>
    </c:if>
</div>
</body>
</html>
