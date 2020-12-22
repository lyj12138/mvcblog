package com.blog.dao;

import com.blog.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    Article selectLastArticle(Integer id);

    Article selectNextArticle(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    int countAllNum();


    List<Article> queryAll();

    List<Article> selectByWord(String word);

    int selectCountById(Integer id);

    List<Article> selectByUserId(Integer id);

    List<Article> selectByIdAndWord(@Param("id") Integer id, @Param("word") String word);
}