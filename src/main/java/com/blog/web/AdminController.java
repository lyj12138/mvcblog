package com.blog.web;

import com.blog.domain.Admin;
import com.blog.domain.AdminLoginLog;
import com.blog.domain.User;
import com.blog.service.impl.AdminLoginLogServiceImpl;
import com.blog.service.impl.ArticleServiceImpl;
import com.blog.service.impl.CommentServiceImpl;
import com.blog.service.impl.UserServiceImpl;
import com.blog.util.MD5;
import com.blog.util.RSAUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    public AdminLoginLogServiceImpl adminLoginLogService;
    @Autowired
    public ArticleServiceImpl articleService;
    @Autowired
    public CommentServiceImpl commentService;
    @Autowired
    public UserServiceImpl userService;
    @RequestMapping("/main")
    public ModelAndView toMain(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("admin/main");
        String clientIp=request.getRemoteAddr();    //获取客户端IP，如：127.0.0.1
        String hostIp=request.getLocalAddr();
        int hostPort=request.getLocalPort();
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");//设置日期格式
        String dates = df.format(date);
        Admin admin=(Admin) request.getSession().getAttribute("admin");
        AdminLoginLog lastLoginLog=null;
        try {
            if (adminLoginLogService.selectRencent(admin.getId())!=null && adminLoginLogService.selectRencent(admin.getId()).size()==2){
                List<AdminLoginLog> adminLoginLogs=adminLoginLogService.selectRencent(admin.getId());
                lastLoginLog=adminLoginLogs.get(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            int articleCount=articleService.selectCount();
            int commentCount=commentService.countAllNum();
            int loginNum=adminLoginLogService.selectCountByAdminId(admin.getId());
            modelAndView.addObject("clientIp",clientIp);
            modelAndView.addObject("hostIp",hostIp);
            modelAndView.addObject("hostPort",hostPort);
            modelAndView.addObject("date",dates);
            if (lastLoginLog!=null){
                modelAndView.addObject("loginLog",lastLoginLog);
            }
            modelAndView.addObject("articleCount",articleCount);
            modelAndView.addObject("commentCount",commentCount);
            modelAndView.addObject("loginNum",loginNum);
            return modelAndView;
        }


    }
    @RequestMapping("/user/state")
    public ModelAndView stateList(@RequestParam(required=true,defaultValue="1") Integer page, @RequestParam(required=false,defaultValue="10") Integer pageSize, HttpServletRequest request){
        PageHelper.startPage(page, pageSize);
        List<User> users=userService.selectByState("未激活");
        PageInfo<User> pageInfo=new PageInfo<User>(users);
        ModelAndView modelAndView=new ModelAndView("/admin/user_list");
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("users",users);
       request.getSession().setAttribute("flag","1");
        return modelAndView;
    }
    @RequestMapping("/user/list")
    public ModelAndView myList(@RequestParam(required=true,defaultValue="1") Integer page, @RequestParam(required=false,defaultValue="10") Integer pageSize, HttpServletRequest request){
        PageHelper.startPage(page, pageSize);
        List<User> users=userService.queryAll();
        PageInfo<User> pageInfo=new PageInfo<User>(users);
        ModelAndView modelAndView=new ModelAndView("/admin/user_list");
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("users",users);
       request.getSession().setAttribute("flag","0");
        return modelAndView;
    }
    @RequestMapping(value = "/user/edit")
    public ModelAndView userEdit(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        User user=userService.getById(id);
        ModelAndView modelAndView=new ModelAndView("/admin/user_edit");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @RequestMapping(value = "/user/edit/do", method = RequestMethod.POST)
    public @ResponseBody Object userEditDo(HttpServletRequest request) throws UnsupportedEncodingException {
         User user=new User();
        HashMap<String, String> res = new HashMap<String, String>();
        request.setCharacterEncoding("UTF-8");
        user.setUsername(MD5.convertMD5(RSAUtil.decryptBase64(request.getParameter("username"))));
        user.setPassword(request.getParameter("password"));
        user.setNickname(request.getParameter("nickname"));
        user.setEmail(MD5.convertMD5(RSAUtil.decryptBase64(request.getParameter("email"))));
        user.setState(request.getParameter("state"));
        user.setId(Integer.parseInt(RSAUtil.decryptBase64(request.getParameter("id"))));
        if (userService.updateByPrimaryKey(user)){
            res.put("stateCode", "1");
        }else {
            res.put("stateCode", "0");
        }
        return res;
    }

    @RequestMapping(value = "/user/del", method = RequestMethod.POST)
    public @ResponseBody Object loginCheck(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        int result=userService.deleteById(id);
        HashMap<String, String> res = new HashMap<String, String>();
        if (result==1){
            res.put("stateCode", "1");
        }else {
            res.put("stateCode", "0");
        }
        return res;
    }

}
