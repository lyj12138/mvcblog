/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-30 07:40:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class comment_005flist_005freply_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/MD5.tld", Long.valueOf(1608609582000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>博客管理系统</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap4.0.min.css\" >\r\n");
      out.write("    <script src=\"/js/jquery.slim.min.js\" ></script>\r\n");
      out.write("    <script src=\"/js/popper.min.js\" ></script>\r\n");
      out.write("    <script src=\"/js/bootstrap4.0.min.js\"></script>\r\n");
      out.write("    <script src=\"/js/layer.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/jsp/comment_list_reply.jsp(25,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty comments}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("        <table class=\"table\">\r\n");
          out.write("            <thead class=\"thead-default\">\r\n");
          out.write("            <tr>\r\n");
          out.write("\r\n");
          out.write("                <th>回复昵称</th>\r\n");
          out.write("                <th>评论内容</th>\r\n");
          out.write("                <th>回复内容</th>\r\n");
          out.write("                <th>日期</th>\r\n");
          out.write("                <th>回复</th>\r\n");
          out.write("            </tr>\r\n");
          out.write("            </thead>\r\n");
          out.write("            <tbody>\r\n");
          out.write("\r\n");
          out.write("            ");
          //  c:forEach
          org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
          _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
          _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
          // /WEB-INF/jsp/comment_list_reply.jsp(39,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
          _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/comment_list_reply.jsp(39,12) '${comments}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${comments}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
          // /WEB-INF/jsp/comment_list_reply.jsp(39,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_c_005fforEach_005f0.setVar("comment");
          int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
          try {
            int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
            if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n");
                out.write("                ");
  int flag=1;
                out.write("\r\n");
                out.write("                ");
 int i =1;    
                out.write("\r\n");
                out.write("                <tr>\r\n");
                out.write("                    <td>");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.nickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                out.write("</td>\r\n");
                out.write("                    ");
                //  c:forEach
                org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
                _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
                _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
                // /WEB-INF/jsp/comment_list_reply.jsp(44,20) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
                _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/comment_list_reply.jsp(44,20) '${allComments}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${allComments}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
                // /WEB-INF/jsp/comment_list_reply.jsp(44,20) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                _jspx_th_c_005fforEach_005f1.setVar("allComment");
                int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
                try {
                  int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
                  if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n");
                      out.write("                        ");
                      //  c:if
                      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
                      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
                      _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
                      // /WEB-INF/jsp/comment_list_reply.jsp(45,24) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${allComment.id==comment.reference}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
                      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
                      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n");
                          out.write("                            <td>");
                          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${allComment.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                          out.write("</td>\r\n");
                          out.write("                            ");
 flag=0;
                          out.write("\r\n");
                          out.write("                            ");
 i++;
                          out.write("\r\n");
                          out.write("                        ");
                          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
                        return;
                      }
                      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
                      out.write("\r\n");
                      out.write("                        ");
                      //  c:if
                      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
                      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
                      _jspx_th_c_005fif_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
                      // /WEB-INF/jsp/comment_list_reply.jsp(50,24) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${allComment.articleId==comment.articleId}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
                      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
                      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n");
                          out.write("                        ");
                          //  c:if
                          org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
                          _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
                          _jspx_th_c_005fif_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f2);
                          // /WEB-INF/jsp/comment_list_reply.jsp(51,24) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                          _jspx_th_c_005fif_005f3.setTest(flag==1);
                          int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
                          if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            do {
                              out.write("\r\n");
                              out.write("                            ");
 i++;
                              out.write("\r\n");
                              out.write("                        ");
                              int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
                              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                              break;
                            } while (true);
                          }
                          if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
                            return;
                          }
                          _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
                          out.write("\r\n");
                          out.write("                        ");
                          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
                        return;
                      }
                      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
                      out.write("\r\n");
                      out.write("                    ");
                      int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    return;
                  }
                } catch (java.lang.Throwable _jspx_exception) {
                  while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
                    out = _jspx_page_context.popBody();
                  _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
                } finally {
                  _jspx_th_c_005fforEach_005f1.doFinally();
                  _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
                }
                out.write("\r\n");
                out.write("                    <td>");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                out.write("</td>\r\n");
                out.write("                    <td>");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.date}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                out.write("</td>\r\n");
                out.write("                    <td><button type=\"button\" class=\"btn btn-outline-danger btn-sm\" onclick=\"ifcomment('");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.nickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                out.write('\'');
                out.write(',');
                out.write('\'');
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                out.write('\'');
                out.write(',');
                out.write('\'');
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.articleId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                out.write('\'');
                out.write(',');
                out.print(i);
                out.write(") \">回复</button></td>\r\n");
                out.write("                </tr>\r\n");
                out.write("            ");
                int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              return;
            }
          } catch (java.lang.Throwable _jspx_exception) {
            while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
              out = _jspx_page_context.popBody();
            _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
          } finally {
            _jspx_th_c_005fforEach_005f0.doFinally();
            _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
          }
          out.write("\r\n");
          out.write("            </tbody>\r\n");
          out.write("        </table>\r\n");
          out.write("        <div id=\"com\" style=\"display: none\">\r\n");
          out.write("            <div  class=\"form-horizontal\" role=\"form\" style=\"margin:10px\">\r\n");
          out.write("                <div class=\"form-group\">\r\n");
          out.write("                    <label id=\"tent\" class=\"col-sm-2 control-label\">评论</label>\r\n");
          out.write("                    <div class=\"col-sm-3\">\r\n");
          out.write("                        <textarea id=\"content\"  class=\"form-control\" rows=\"3\"  placeholder=\"文明上网，理性发言\" ></textarea>\r\n");
          out.write("                    </div>\r\n");
          out.write("                </div>\r\n");
          out.write("                <input id=\"articleId\" type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${article.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" >\r\n");
          out.write("                <input id=\"reference\" type=\"hidden\" name=\"reference\" value=\"0\">\r\n");
          out.write("                <input id=\"floor\" type=\"hidden\" name=\"floor\" value=\"0\">\r\n");
          out.write("                <div class=\"form-group\" style=\"position:relative;left:13%\">\r\n");
          out.write("                    <br/>\r\n");
          out.write("                    <p style=\"text-align: right;color: red;position: absolute\" id=\"info\"></p>\r\n");
          out.write("                    <br/>\r\n");
          out.write("                    <button id=\"commentButton\" class=\"btn btn-outline-danger btn-sm\" onclick=\"doComment()\">回复</button>\r\n");
          out.write("                    <button id=\"Button\" class=\"btn btn-outline-danger btn-sm\" onclick=\"cancelComment()\">取消回复</button>\r\n");
          out.write("                </div>\r\n");
          out.write("            </div>\r\n");
          out.write("        </div>\r\n");
          out.write("\r\n");
          out.write("        <script src=\"/js/jquery-3.2.1.min.js\"></script>\r\n");
          out.write("        <script>\r\n");
          out.write("            function ifcomment(nickname,reference,articleId,i){\r\n");
          out.write("                $(\"#com\").attr('style','');\r\n");
          out.write("                $(\"#tent\").html(\"回复\"+nickname+\":\");\r\n");
          out.write("                $(\"#reference\").attr('value',reference)\r\n");
          out.write("                $(\"#floor\").attr('value',i)\r\n");
          out.write("                $(\"#articleId\").attr('value',articleId)\r\n");
          out.write("            }\r\n");
          out.write("            function cancelComment() {\r\n");
          out.write("                $(\"#com\").attr('style','display:none');\r\n");
          out.write("            }\r\n");
          out.write("            function doComment() {\r\n");
          out.write("\r\n");
          out.write("                if ($(\"#content\").val()==''){\r\n");
          out.write("                    $(\"#info\").text(\"提示:请输入评论内容\");\r\n");
          out.write("                }\r\n");
          out.write("                else {\r\n");
          out.write("                    $(\"#info\").text(\"\");\r\n");
          out.write("                    $.ajax({\r\n");
          out.write("                        type: \"POST\",\r\n");
          out.write("                        url: \"/api/comment/add\",\r\n");
          out.write("                        data: {\r\n");
          out.write("                            reference: $(\"#reference\").val(),\r\n");
          out.write("                            floor: $(\"#floor\").val(),\r\n");
          out.write("                            articleId:$(\"#articleId\").val(),\r\n");
          out.write("                            content:$(\"#content\").val()\r\n");
          out.write("                        },\r\n");
          out.write("                        dataType: \"json\",\r\n");
          out.write("                        success: function(data) {\r\n");
          out.write("                            if(data.stateCode.trim() == \"1\") {\r\n");
          out.write("                                $(\"#info\").text(\"评论成功,跳转中...\");\r\n");
          out.write("                                setTimeout(\"window.location.reload()\",1000);\r\n");
          out.write("                            } else  {\r\n");
          out.write("                                $(\"#info\").text(\"评论失败...\");\r\n");
          out.write("                            }\r\n");
          out.write("                        }\r\n");
          out.write("                    });\r\n");
          out.write("                }\r\n");
          out.write("            }\r\n");
          out.write("        </script>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent(null);
    // /WEB-INF/jsp/comment_list_reply.jsp(126,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty comments}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("        <div class=\"card\">\r\n");
        out.write("            <div class=\"card-body\">\r\n");
        out.write("                该文章暂无评论!\r\n");
        out.write("            </div>\r\n");
        out.write("        </div>\r\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
    return false;
  }
}
