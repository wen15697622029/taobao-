package com.w.service.impl;

import com.w.dao.CommentDao;
import com.w.model.Comment;
import com.w.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by destiny on 2018/7/8/0008.
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentDao commentDao = null;

    @Override
    public boolean addComment(Comment comment1) {
        return commentDao.addComment(comment1);
    }
}
