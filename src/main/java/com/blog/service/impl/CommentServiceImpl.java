package com.blog.service.impl;

import com.blog.dao.CommentDao;
import com.blog.domain.Comment;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    public CommentDao commentDao;
    public List<Comment> allComments(int article_id) {
        return commentDao.queryAll(article_id);
    }

    public int insertComment(Comment comment) {
        return commentDao.insertSelective(comment);
    }

    public int countAllNum() {
        return commentDao.countAllNum();
    }

    public boolean delById(Long id) {
        return commentDao.deleteByPrimaryKey(id)>0;
    }

    @Override
    public List<Comment> userComments(String username) {
        return commentDao.userComments(username);
    }

    @Override
    public List<Comment> list() {
        return commentDao.list();
    }

    @Override
    public List<Comment> userCommentsReply(String username) {
        return  commentDao.userCommentsReply(username);
    }
}
