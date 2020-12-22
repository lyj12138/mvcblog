package com.blog.web;

import com.blog.domain.Admin;
import com.blog.domain.AdminLoginLog;
import com.blog.domain.User;
import com.blog.service.impl.AdminLoginLogServiceImpl;
import com.blog.service.impl.ArticleServiceImpl;
import com.blog.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
@RequestMapping("/user")
public class UserController {
    @Autowired
    public AdminLoginLogServiceImpl adminLoginLogService;
    @Autowired
    public ArticleServiceImpl articleService;
    @Autowired
    public CommentServiceImpl commentService;
    @RequestMapping("/main")
    public ModelAndView toMain(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("/userBlog");
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
            int articleCount=articleService.selectCountById(user.getId());
            modelAndView.addObject("articleCount",articleCount);
            return modelAndView;
    }
}
