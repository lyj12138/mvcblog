/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-26 06:51:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>博客系统</title>\r\n");
      out.write("    <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"/img/web-icon.png\" media=\"screen\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\">\r\n");
      out.write("    <script src=\"/js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("    <script src=\"/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"/js/md5.js\"></script>\r\n");
      out.write("    <script src=\"/js/convert.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("        #myCarousel{\r\n");
      out.write("            margin-left: 2%;\r\n");
      out.write("            width: 900px;\r\n");
      out.write("            height: 80%;\r\n");
      out.write("            float: left;\r\n");
      out.write("            z-index: 999;\r\n");
      out.write("            display: inline;\r\n");
      out.write("        }\r\n");
      out.write("        #login{\r\n");
      out.write("            float: left;\r\n");
      out.write("            height: 250px;\r\n");
      out.write("            width: 330px;\r\n");
      out.write("            margin-left: 6%;\r\n");
      out.write("            margin-top: 9%;\r\n");
      out.write("            display: inline;\r\n");
      out.write("            z-index: 999;\r\n");
      out.write("        }\r\n");
      out.write("        body{\r\n");
      out.write("            padding:0;\r\n");
      out.write("            margin:0;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script>\r\n");
      out.write("        $(function(){\r\n");
      out.write("            $('#myCarousel').carousel({\r\n");
      out.write("                interval: 2000\r\n");
      out.write("            })\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"getPic()\">\r\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<h2 style=\"text-align: center;font-family: 'Adobe 楷体 Std R';color: black\">博客系统</h2>\r\n");
      out.write("<div style=\"float:right;\" id=\"github_iframe\"></div>\r\n");
      out.write("<script>\r\n");
      out.write("    ! function() {\r\n");
      out.write("        //封装方法，压缩之后减少文件大小\r\n");
      out.write("        function get_attribute(node, attr, default_value) {\r\n");
      out.write("            return node.getAttribute(attr) || default_value;\r\n");
      out.write("        }\r\n");
      out.write("        //封装方法，压缩之后减少文件大小\r\n");
      out.write("        function get_by_tagname(name) {\r\n");
      out.write("            return document.getElementsByTagName(name);\r\n");
      out.write("        }\r\n");
      out.write("        //获取配置参数\r\n");
      out.write("        function get_config_option() {\r\n");
      out.write("            var scripts = get_by_tagname(\"script\"),\r\n");
      out.write("                script_len = scripts.length,\r\n");
      out.write("                script = scripts[script_len - 1]; //当前加载的script\r\n");
      out.write("            return {\r\n");
      out.write("                l: script_len, //长度，用于生成id用\r\n");
      out.write("                z: get_attribute(script, \"zIndex\", -1), //z-index\r\n");
      out.write("                o: get_attribute(script, \"opacity\", 0.5), //opacity\r\n");
      out.write("                c: get_attribute(script, \"color\", \"0,0,0\"), //color\r\n");
      out.write("                n: get_attribute(script, \"count\", 99) //count\r\n");
      out.write("            };\r\n");
      out.write("        }\r\n");
      out.write("        //设置canvas的高宽\r\n");
      out.write("        function set_canvas_size() {\r\n");
      out.write("            canvas_width = the_canvas.width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth,\r\n");
      out.write("                canvas_height = the_canvas.height = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;\r\n");
      out.write("        }\r\n");
      out.write("        //绘制过程\r\n");
      out.write("        function draw_canvas() {\r\n");
      out.write("            context.clearRect(0, 0, canvas_width, canvas_height);\r\n");
      out.write("            //随机的线条和当前位置联合数组\r\n");
      out.write("            var e, i, d, x_dist, y_dist, dist; //临时节点\r\n");
      out.write("            //遍历处理每一个点\r\n");
      out.write("            random_points.forEach(function(r, idx) {\r\n");
      out.write("                r.x += r.xa,\r\n");
      out.write("                    r.y += r.ya, //移动\r\n");
      out.write("                    r.xa *= r.x > canvas_width || r.x < 0 ? -1 : 1,\r\n");
      out.write("                    r.ya *= r.y > canvas_height || r.y < 0 ? -1 : 1, //碰到边界，反向反弹\r\n");
      out.write("                    context.fillRect(r.x - 0.5, r.y - 0.5, 1, 1); //绘制一个宽高为1的点\r\n");
      out.write("                //从下一个点开始\r\n");
      out.write("                for (i = idx + 1; i < all_array.length; i++) {\r\n");
      out.write("                    e = all_array[i];\r\n");
      out.write("                    // 当前点存在\r\n");
      out.write("                    if (null !== e.x && null !== e.y) {\r\n");
      out.write("                        x_dist = r.x - e.x; //x轴距离 l\r\n");
      out.write("                        y_dist = r.y - e.y; //y轴距离 n\r\n");
      out.write("                        dist = x_dist * x_dist + y_dist * y_dist; //总距离, m\r\n");
      out.write("                        dist < e.max && (e === current_point && dist >= e.max / 2 && (r.x -= 0.03 * x_dist, r.y -= 0.03 * y_dist), //靠近的时候加速\r\n");
      out.write("                            d = (e.max - dist) / e.max,\r\n");
      out.write("                            context.beginPath(),\r\n");
      out.write("                            context.lineWidth = d / 2,\r\n");
      out.write("                            context.strokeStyle = \"rgba(\" + config.c + \",\" + (d + 0.2) + \")\",\r\n");
      out.write("                            context.moveTo(r.x, r.y),\r\n");
      out.write("                            context.lineTo(e.x, e.y),\r\n");
      out.write("                            context.stroke());\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            }), frame_func(draw_canvas);\r\n");
      out.write("        }\r\n");
      out.write("        //创建画布，并添加到body中\r\n");
      out.write("        var the_canvas = document.createElement(\"canvas\"), //画布\r\n");
      out.write("            config = get_config_option(), //配置\r\n");
      out.write("            canvas_id = \"c_n\" + config.l, //canvas id\r\n");
      out.write("            context = the_canvas.getContext(\"2d\"), canvas_width, canvas_height,\r\n");
      out.write("            frame_func = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame || function(func) {\r\n");
      out.write("                window.setTimeout(func, 1000 / 45);\r\n");
      out.write("            }, random = Math.random,\r\n");
      out.write("            current_point = {\r\n");
      out.write("                x: null, //当前鼠标x\r\n");
      out.write("                y: null, //当前鼠标y\r\n");
      out.write("                max: 20000 // 圈半径的平方\r\n");
      out.write("            },\r\n");
      out.write("            all_array;\r\n");
      out.write("        the_canvas.id = canvas_id;\r\n");
      out.write("        the_canvas.style.cssText = \"position:fixed;top:0;left:0;z-index:\" + config.z + \";opacity:\" + config.o;\r\n");
      out.write("        get_by_tagname(\"body\")[0].appendChild(the_canvas);\r\n");
      out.write("        //初始化画布大小\r\n");
      out.write("        set_canvas_size();\r\n");
      out.write("        window.onresize = set_canvas_size;\r\n");
      out.write("        //当时鼠标位置存储，离开的时候，释放当前位置信息\r\n");
      out.write("        window.onmousemove = function(e) {\r\n");
      out.write("            e = e || window.event;\r\n");
      out.write("            current_point.x = e.clientX;\r\n");
      out.write("            current_point.y = e.clientY;\r\n");
      out.write("        }, window.onmouseout = function() {\r\n");
      out.write("            current_point.x = null;\r\n");
      out.write("            current_point.y = null;\r\n");
      out.write("        };\r\n");
      out.write("        //随机生成config.n条线位置信息\r\n");
      out.write("        for (var random_points = [], i = 0; config.n > i; i++) {\r\n");
      out.write("            var x = random() * canvas_width, //随机位置\r\n");
      out.write("                y = random() * canvas_height,\r\n");
      out.write("                xa = 2 * random() - 1, //随机运动方向\r\n");
      out.write("                ya = 2 * random() - 1;\r\n");
      out.write("            // 随机点\r\n");
      out.write("            random_points.push({\r\n");
      out.write("                x: x,\r\n");
      out.write("                y: y,\r\n");
      out.write("                xa: xa,\r\n");
      out.write("                ya: ya,\r\n");
      out.write("                max: 6000 //沾附距离\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("        all_array = random_points.concat([current_point]);\r\n");
      out.write("        //0.1秒后绘制\r\n");
      out.write("        setTimeout(function() {\r\n");
      out.write("            draw_canvas();\r\n");
      out.write("        }, 100);\r\n");
      out.write("    }();\r\n");
      out.write("</script>\r\n");
      out.write("<div id=\"myCarousel\" class=\"carousel slide\">\r\n");
      out.write("    <ol class=\"carousel-indicators\">\r\n");
      out.write("        <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("        <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\r\n");
      out.write("        <li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\r\n");
      out.write("    </ol>\r\n");
      out.write("    <div class=\"carousel-inner\">\r\n");
      out.write("        <div class=\"item active\">\r\n");
      out.write("            <img src=\"/img/1.jpg\" alt=\"第一张\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"item\">\r\n");
      out.write("            <img src=\"/img/2.jpg\" alt=\"第二张\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"item\">\r\n");
      out.write("            <img src=\"/img/3.jpg\" alt=\"第三张\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <a class=\"carousel-control left\" href=\"#myCarousel\"\r\n");
      out.write("       data-slide=\"prev\">&lsaquo;\r\n");
      out.write("    </a>\r\n");
      out.write("    <a class=\"carousel-control right\" href=\"#myCarousel\"\r\n");
      out.write("       data-slide=\"next\">&rsaquo;\r\n");
      out.write("    </a>\r\n");
      out.write("</div>\r\n");
      out.write("<div  id=\"login\">\r\n");
      out.write("    <div class=\"form-inline\"  >\r\n");
      out.write("\r\n");
      out.write("        <div class=\"input-group\">\r\n");
      out.write("            <span class=\"input-group-addon\">账号</span>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"id\" id=\"adminId\">\r\n");
      out.write("        </div><br/><br/>\r\n");
      out.write("        <div class=\"input-group\">\r\n");
      out.write("            <span class=\"input-group-addon\">密码</span>\r\n");
      out.write("            <input type=\"password\" class=\"form-control\" name=\"passwd\" id=\"passwd\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <br/><br/>\r\n");
      out.write("        <div class=\"input-group\">\r\n");
      out.write("            <span class=\"input-group-addon\">验证码</span>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"fpasswd\"   id=\"fpasswd\" style=\"width: 100px\" >\r\n");
      out.write("            <img id=\"fimg\" src=\"\"  alt=\"\"   style=\"width: 100px;cursor:pointer;\" onclick=\"getPic()\"/>\r\n");
      out.write("            <script type=\"text/javascript\">\r\n");
      out.write("                function getPic(){\r\n");
      out.write("                    $(\"#fimg\").attr(\"src\",\"/api/checkCode??flag=\"+Math.random());\r\n");
      out.write("                }\r\n");
      out.write("            </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <br/>\r\n");
      out.write("        <p style=\"text-align: right;color: red;position: absolute\" id=\"info\"></p>\r\n");
      out.write("\r\n");
      out.write("        <br/>\r\n");
      out.write("        <button id=\"loginButton\"  class=\"btn btn-primary\">登陆\r\n");
      out.write("        </button>\r\n");
      out.write("        <button id=\"toRegister\" class=\"btn btn-primary\">没有账号？请点击前往登录</button>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <script src=\"http://passport.cnblogs.com/scripts/jsencrypt.min.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        $(\"#loginButton\").click(function () {\r\n");
      out.write("            if($(\"#adminId\").val()==''&&$(\"#passwd\").val()==''){\r\n");
      out.write("                $(\"#info\").text(\"提示:账号和密码不能为空\");\r\n");
      out.write("            }\r\n");
      out.write("            else if ($(\"#adminId\").val()==''){\r\n");
      out.write("                $(\"#info\").text(\"提示:账号不能为空\");\r\n");
      out.write("            }\r\n");
      out.write("            else if($(\"#passwd\").val()==''){\r\n");
      out.write("                $(\"#info\").text(\"提示:密码不能为空\");\r\n");
      out.write("            }\r\n");
      out.write("            else if($(\"#fpasswd\").val()==''){\r\n");
      out.write("                $(\"#info\").text(\"提示:请输入验证码\");\r\n");
      out.write("            }\r\n");
      out.write("            else {\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: \"/api/getRSA\",\r\n");
      out.write("                    type: \"GET\",\r\n");
      out.write("                    dataType: \"json\",\r\n");
      out.write("                    async: false,\r\n");
      out.write("                    success: function (res) {\r\n");
      out.write("                        var encrypt = new JSEncrypt();\r\n");
      out.write("                        if (res) {\r\n");
      out.write("                            var publicKey = null;\r\n");
      out.write("                            publicKey = res.publicKey;\r\n");
      out.write("                            var id;\r\n");
      out.write("                            encrypt.setPublicKey(publicKey);\r\n");
      out.write("                            id = encrypt.encrypt($(\"#adminId\").val());\r\n");
      out.write("                            $.ajax({\r\n");
      out.write("                                type: \"POST\",\r\n");
      out.write("                                url: \"/api/userCheck\",\r\n");
      out.write("                                data: {\r\n");
      out.write("                                    id: id,\r\n");
      out.write("                                    password: $.md5($(\"#passwd\").val()),\r\n");
      out.write("                                    code: $(\"#fpasswd\").val()\r\n");
      out.write("                                },\r\n");
      out.write("                                dataType: \"json\",\r\n");
      out.write("                                success: function (data) {\r\n");
      out.write("                                    if (data.stateCode.trim() == \"0\") {\r\n");
      out.write("                                        $(\"#info\").text(\"提示:该用户不存在\");\r\n");
      out.write("                                        getPic();\r\n");
      out.write("                                    } else if (data.stateCode.trim() == \"1\") {\r\n");
      out.write("                                        $(\"#info\").text(\"提示:密码错误\");\r\n");
      out.write("                                        getPic();\r\n");
      out.write("                                    } else if (data.stateCode.trim() == \"2\") {\r\n");
      out.write("                                        $(\"#info\").text(\"提示:登陆成功，跳转中...\");\r\n");
      out.write("                                        window.location.href = \"/user/main\";\r\n");
      out.write("                                    } else {\r\n");
      out.write("                                        $(\"#info\").text(\"提示:验证码错误\");\r\n");
      out.write("                                        getPic();\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("                            });\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("        $(\"#toRegister\").click(function () {\r\n");
      out.write("\r\n");
      out.write("            location.replace(\"/user/register\");\r\n");
      out.write("\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsp/userLogin.jsp(52,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty error}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("    <script>\r\n");
        out.write("        alert(\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\");\r\n");
        out.write("        window.location.href=\"login.html\";\r\n");
        out.write("    </script>\r\n");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
