package com.blog.service;

import com.blog.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> allComments(int article_id);
    int insertComment(Comment comment);
    int countAllNum();
    boolean delById(Long id);

    List<Comment> userComments(String username);

    List<Comment> list();

    List<Comment> userCommentsReply(String username);
}
