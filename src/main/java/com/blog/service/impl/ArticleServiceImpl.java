package com.blog.service.impl;

import com.blog.dao.ArticleDao;
import com.blog.domain.Article;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    public ArticleDao articleDao;

    public Article selectById(Integer id) {
        return articleDao.selectByPrimaryKey(id);
    }

    public List<Article> queryAll() {
        return articleDao.queryAll();
    }

    public int countAllNum() {
        return articleDao.countAllNum();
    }

    public boolean updateArticle(Article article) {
        return articleDao.updateByPrimaryKeySelective(article)>0;
    }

    public int deleteById(Integer id) {
        return articleDao.deleteByPrimaryKey(id);
    }

    public int selectCount() {
        return articleDao.countAllNum();
    }

    public List<Article> selectByWord(String word) {
        return articleDao.selectByWord(word);
    }

    public boolean insert(Article article) {
        return articleDao.insert(article)>0;
    }

    public Article selectLastArticle(Integer id) {
        return articleDao.selectLastArticle(id);
    }

    public Article selectNextArticle(Integer id) {
        return articleDao.selectNextArticle(id);
    }

    @Override
    public int selectCountById(Integer id) {
        return articleDao.selectCountById(id);
    }

    @Override
    public List<Article> selectByUserId(Integer id) {
        return articleDao.selectByUserId(id);
    }

    @Override
    public List<Article> selectByIdAndWord(Integer id, String word) {
        return articleDao.selectByIdAndWord(id,word);
    }
}
