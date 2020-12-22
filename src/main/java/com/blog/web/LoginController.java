package com.blog.web;

import com.blog.domain.Admin;
import com.blog.domain.AdminLoginLog;
import com.blog.domain.User;
import com.blog.service.UserService;
import com.blog.service.impl.AdminLoginLogServiceImpl;
import com.blog.service.impl.AdminServiceImpl;
import com.blog.service.impl.UserServiceImpl;
import com.blog.util.MD5;
import com.blog.util.RandomValidateCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;


@Controller

public class LoginController {
    @Autowired
    AdminServiceImpl adminService;
    @Autowired
    AdminLoginLogServiceImpl adminLoginLogService;
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = {"/admin/index","/admin","/admin/login"})
    public String toIndex(HttpServletRequest request) {

        return "admin/login";

    }
    @RequestMapping(value = {"/user","/user/login"})
    public String toUser(HttpServletRequest request) {


        return "/userLogin";

    }

    @RequestMapping(value="/api/checkCode")
    public  void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("image/jpeg");
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            String code_key=randomValidateCode.getRandcode(request, response);
            request.getSession().setAttribute("code_key",code_key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = {"/user/register"})
    public String toRegister(HttpServletRequest request) {

        return "/userRegister";

    }

    // 0:用户不存在  1:密码错误 2:登陆成功
    @RequestMapping(value = "/api/userCheck", method = RequestMethod.POST)
    public @ResponseBody Object loginCheck(HttpServletRequest request,HttpServletResponse httpServletResponse) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id=MD5.convertMD5(MD5.convertMD6(request.getParameter("id")));
        String code=request.getParameter("code");
        String code_key=(String) request.getSession().getAttribute("code_key");
        String passwd=MD5.getMD5( request.getParameter("password"));
        HashMap<String, String> res = new HashMap<String, String>();
        System.out.println(id);
        if(userService.getByEmail(id)!=null||userService.getByUserName(id)!=null){
            if((userService.getByUserName(id)!=null&&userService.getByUserName(id).getPassword().equals(passwd))||(userService.getByEmail(id)!=null&&userService.getByEmail(id).getPassword().equals(passwd))){
                System.out.println(code+code_key);
                if(code.equals(code_key)){
                    if(userService.getByEmail(id)!=null) {
                        request.getSession().setAttribute("user", userService.getByEmail(id));
                    }
                    else {
                        request.getSession().setAttribute("user", userService.getByUserName(id));
                    }
                    res.put("stateCode", "2");
                }
                else
                    res.put("stateCode", "3");
            }
            else
                res.put("stateCode", "1");
        }
        else
            res.put("stateCode", "0");

    return res;
    }

    @RequestMapping(value = "/api/registerCheck", method = RequestMethod.POST)
    public @ResponseBody Object registerCheck(HttpServletRequest request,HttpServletResponse httpServletResponse) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        HashMap<String, String> res = new HashMap<String, String>();
        String  username=MD5.convertMD5(MD5.convertMD6(request.getParameter("username")));
        String passwd =MD5.getMD5(request.getParameter("password"));
        String email = MD5.convertMD5(MD5.convertMD6(request.getParameter("email")));
        String nickname = request.getParameter("nickname");
        if(userService.getByEmail(email)!=null){
            res.put("stateCode", "0");
        }
        else if(userService.getByUserName(username)!=null){
            res.put("stateCode", "1");
        }else {
             User user=new User();
             user.setEmail(email);
             user.setNickname(nickname);
             user.setPassword(passwd);
             user.setUsername(username);
             userService.insertSelective(user);
            request.getSession().setAttribute("user",userService.getByEmail(email));
            res.put("stateCode", "2");
        }

        return res;
    }
    // 0:用户不存在  1:密码错误 2:登陆成功
    @RequestMapping(value = "/api/loginCheck", method = RequestMethod.POST)
    public @ResponseBody Object userCheck(HttpServletRequest request,HttpServletResponse httpServletResponse) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        String passwd = request.getParameter("password");
        HashMap<String, String> res = new HashMap<String, String>();
        if(adminService.getById(id)==null){
            res.put("stateCode", "0");
        }
        else if(!adminService.getById(id).getPassword().equals(passwd)){
            res.put("stateCode", "1");
        }else {
            String ip=request.getRemoteAddr();
            AdminLoginLog adminLoginLog=new AdminLoginLog();
            adminLoginLog.setAdminId(id);
            adminLoginLog.setDate(new Date());
            adminLoginLog.setIp(ip);
            int log=adminLoginLogService.insert(adminLoginLog);
            Cookie cookie = new Cookie("userId",""+id);
            cookie.setMaxAge(3600*24);
            httpServletResponse.addCookie(cookie);
            request.getSession().setAttribute("admin",adminService.getById(id));
            res.put("stateCode", "2");
        }

        return res;
    }
    @RequestMapping(value = {"/admin/logout"})
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        request.getSession().removeAttribute("admin");
        return "redirect:/admin";

    }
    @RequestMapping(value = {"/user/logout"})
    public String userlogout(HttpServletRequest request,HttpServletResponse response) {
        //System.out.println("注销登录");
        request.getSession().removeAttribute("user");
        return "redirect:/user/login";
    }

}
