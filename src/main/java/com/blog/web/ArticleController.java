package com.blog.web;

import com.blog.domain.Article;
import com.blog.domain.Comment;
import com.blog.domain.User;
import com.blog.service.impl.ArticleServiceImpl;
import com.blog.service.impl.CommentServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    public CommentServiceImpl commentService;

    @RequestMapping("/article")
    public ModelAndView detail(HttpServletRequest request){

        int id=Integer.parseInt(request.getParameter("id"));
        List<Comment> comments=commentService.allComments(id);
        Article article=articleService.selectById(id);
        Article lastArticle=articleService.selectLastArticle(id);
        Article nextArticle=articleService.selectNextArticle(id);

        Integer clickNum=article.getClick();
        article.setClick(clickNum+1);
        articleService.updateArticle(article);
        ModelAndView modelAndView=new ModelAndView("detail");
        modelAndView.addObject("article",article);
        modelAndView.addObject("comments",comments);
        modelAndView.addObject("lastArticle",lastArticle);
        modelAndView.addObject("nextArticle",nextArticle);
        return modelAndView;
    }

    @RequestMapping("/admin/article/detail")
    public ModelAndView adminArticleDetail(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        Article article=articleService.selectById(id);

        ModelAndView modelAndView=new ModelAndView("/admin/article_detail");
        modelAndView.addObject("article",article);


        return modelAndView;
    }
    @RequestMapping("/admin/article/comment")
    public ModelAndView adminArticleComment(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        List<Comment> comments=commentService.allComments(id);
        ModelAndView modelAndView=new ModelAndView("/admin/comment_list");
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }
    @RequestMapping("/user/article/comment")
    public ModelAndView userArticleComment(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        List<Comment> comments=commentService.allComments(id);
        ModelAndView modelAndView=new ModelAndView("/my_comment_list");
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }
    @RequestMapping("/user/comment")
    public ModelAndView userComment(HttpServletRequest request){
       User user=(User)request.getSession().getAttribute("user");
        List<Comment> comments=commentService.userComments(user.getUsername());
        List<Comment> allComments=commentService.list();
        ModelAndView modelAndView=new ModelAndView("/comment_list");
        modelAndView.addObject("comments",comments);
        modelAndView.addObject("allComments",allComments);
        return modelAndView;
    }
    @RequestMapping("/user/comment/reply")
    public ModelAndView userCommentReply(HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        List<Comment> comments=commentService.userCommentsReply(user.getUsername());
        List<Comment> allComments=commentService.list();
        ModelAndView modelAndView=new ModelAndView("/comment_list_reply");
        modelAndView.addObject("comments",comments);
        modelAndView.addObject("allComments",allComments);
        return modelAndView;
    }
    @RequestMapping("/admin/article/list")
    public ModelAndView articleList(@RequestParam(required=true,defaultValue="1") Integer page, @RequestParam(required=false,defaultValue="10") Integer pageSize){
        PageHelper.startPage(page, pageSize);
        List<Article> articles=articleService.queryAll();
        PageInfo<Article> pageInfo=new PageInfo<Article>(articles);
        ModelAndView modelAndView=new ModelAndView("/admin/article_list");
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("word",null);
        return modelAndView;
    }
    @RequestMapping("/user/article/list")
    public ModelAndView myList(@RequestParam(required=true,defaultValue="1") Integer page, @RequestParam(required=false,defaultValue="10") Integer pageSize,HttpServletRequest request){
        PageHelper.startPage(page, pageSize);
        User user=(User)request.getSession().getAttribute("user");
        List<Article> articles=articleService.selectByUserId(user.getId());
        PageInfo<Article> pageInfo=new PageInfo<Article>(articles);
        ModelAndView modelAndView=new ModelAndView("/my_list");
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("word",null);
        System.out.println(pageInfo.getSize());
        return modelAndView;
    }
    @RequestMapping("/admin/article/add")
    public ModelAndView articleAdd(){
        ModelAndView modelAndView=new ModelAndView("/admin/article_add");
        return modelAndView;
    }
    @RequestMapping("/admin/article/add/do")
    public String articleAddDo(HttpServletRequest request,RedirectAttributes redirectAttributes) throws UnsupportedEncodingException {
        Article article=new Article();
        User user=(User)request.getSession().getAttribute("user");
        request.setCharacterEncoding("UTF-8");
        article.setTitle(request.getParameter("title"));
        article.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
        article.setKeywords(request.getParameter("keywords"));
        article.setdesci(request.getParameter("desci"));
        article.setContent(request.getParameter("content"));
        article.setUserId(user.getId());
        article.setTime(new Date());
        if (articleService.insert(article)){
            redirectAttributes.addFlashAttribute("succ", "发表文章成功！");
            return "redirect:/admin/article/add";
        }else {
            redirectAttributes.addFlashAttribute("error", "发表文章失败！");
            return "redirect:/admin/article/add";
        }
    }
    @RequestMapping(value = "/admin/article/search")
    public ModelAndView articleSearch(@RequestParam(required=true,defaultValue="1") Integer page, @RequestParam(required=false,defaultValue="10") Integer pageSize,HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String word=request.getParameter("word");
        PageHelper.startPage(page, pageSize);
        List<Article> articles=articleService.selectByWord(word);
        PageInfo<Article> pageInfo=new PageInfo<Article>(articles);
        ModelAndView modelAndView=new ModelAndView("/admin/article_list");
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("word",word);
        return modelAndView;
    }
    @RequestMapping(value = "/user/article/search")
    public ModelAndView mySearch(@RequestParam(required=true,defaultValue="1") Integer page, @RequestParam(required=false,defaultValue="10") Integer pageSize,HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String word=request.getParameter("word");
        User user=(User)request.getSession().getAttribute("user");
        PageHelper.startPage(page, pageSize);
        List<Article> articles=articleService.selectByIdAndWord(user.getId(),word);
        ModelAndView modelAndView=new ModelAndView("/my_list");
        PageInfo<Article> pageInfo=new PageInfo<Article>(articles);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("word",word);
        System.out.println(pageInfo.getSize());
        return modelAndView;
    }
    @RequestMapping(value = "/admin/article/edit")
    public ModelAndView articleEdit(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        Article article=articleService.selectById(id);
        ModelAndView modelAndView=new ModelAndView("/admin/article_edit");
        modelAndView.addObject("article",article);
        return modelAndView;
    }
    @RequestMapping(value = "/admin/article/edit/do")
    public ModelAndView articleEditDo(HttpServletRequest request) throws UnsupportedEncodingException {
        Article article=new Article();
        request.setCharacterEncoding("UTF-8");
        article.setId(Integer.parseInt(request.getParameter("id")));
        article.setTitle(request.getParameter("title"));
        article.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
        article.setKeywords(request.getParameter("keywords"));
        article.setdesci(request.getParameter("desci"));
        article.setContent(request.getParameter("content"));
        System.out.println(article.getContent());
        ModelAndView modelAndView=new ModelAndView("/admin/article_edit");
        if (articleService.updateArticle(article)){
            modelAndView.addObject("succ", "修改文章成功！");

        }else {
            modelAndView.addObject("error", "修改文章失败！");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/api/article/del", method = RequestMethod.POST)
    public @ResponseBody Object loginCheck(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        int result=articleService.deleteById(id);
        HashMap<String, String> res = new HashMap<String, String>();
        if (result==1){
            res.put("stateCode", "1");
        }else {
            res.put("stateCode", "0");
        }
        return res;
    }
}
