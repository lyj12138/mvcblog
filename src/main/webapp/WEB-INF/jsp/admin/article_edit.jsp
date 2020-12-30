
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/bootstrap4.0.min.css" >
    <script src="/js/jquery.slim.min.js" ></script>
    <script src="/js/popper.min.js" ></script>
    <script src="/js/bootstrap4.0.min.js"></script>
    <script type="text/javascript" src="/js/wangEditor.min.js"></script>
</head>
<body>
<div style="position: relative;top: 10%">
    <c:if test="${!empty succ}">
        <div class="alert alert-success" role="alert">
                ${succ}
        </div>
    </c:if>
    <c:if test="${!empty error}">
        <div class="alert alert-danger" role="alert">
                ${error}
        </div>
    </c:if>
</div>
<div class="container">
    <form action="/admin/article/edit/do" method="post">
        <input type="hidden" value="${article.id}" name="id">
        <div class="form-group">
            <label for="title">文章标题</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="文章标题" value="${article.title}">
        </div>
        <div class="form-group">
            <label for="catalogId">栏目</label>
            <select class="form-control" id="catalogId" name="catalogId">
                <option value="0" <c:if test="${article.catalogId==0}">selected="selected"</c:if>>学习</option>
                <option value="1" <c:if test="${article.catalogId==1}">selected="selected"</c:if>>生活</option>
            </select>
        </div>
        <div class="form-group">
            <label for="keywords">关键字</label>
            <input type="text" class="form-control" id="keywords" name="keywords" placeholder="关键字" value="${article.keywords}">
        </div>
        <div class="form-group">
            <label for="desci">简介</label>
            <textarea class="form-control" id="desci" rows="3" name="desci" placeholder="简介">${article.desci}</textarea>
        </div>

        <div class="form-group">
            <label for="div1">内容</label>
            <div id="div1">
                ${article.content}
            </div>
            <textarea id="content" name="content" style="display: none" ></textarea>
        </div>
        <input type="submit" value="修改">
    </form>

    <script>
        var E = window.wangEditor
        var editor = new E('#div1')
        var $text1 = $('#content')
        editor.customConfig.onchange = function (html) {
            $text1.val(html)
        }
        editor.customConfig.uploadImgServer = '/uploadImg'
        editor.customConfig.uploadFileName = 'myFileName'

        editor.customConfig.uploadImgTimeout = 30000

        editor.customConfig.uploadImgHooks = {
            before: function (xhr, editor, files) {

            },
            success: function (xhr, editor, result) {

                var url = result.url
                alert(url)



            },
            fail: function (xhr, editor, result) {

                alert("fail：" + result);
            },
            error: function (xhr, editor) {

            },
            timeout: function (xhr, editor) {

            },


            customInsert: function (insertImg, result, editor) {

                var url = result.url
                insertImg(url)

            }
        }
        editor.create()
        // 初始化 textarea 的值
        $text1.val(editor.txt.html())

    </script>
        </div>
</body>
</html>