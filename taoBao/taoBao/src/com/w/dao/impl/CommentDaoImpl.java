package com.w.dao.impl;

import com.w.dao.CommentDao;
import com.w.model.Comment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/8/0008.
 */
@Repository
public class CommentDaoImpl implements CommentDao{
    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean addComment(Comment comment1) {
        hibernateTemplate.save(comment1);
        return true;
    }
}
