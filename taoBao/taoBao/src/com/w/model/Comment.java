package com.w.model;

import java.io.Serializable;

/**
 * Created by destiny on 2018/7/6/0006.
 */
public class Comment implements Serializable{
    private int id;
    private Good good;
    private String comment;
    private User user;

    public Comment(Good good, String comment, User user) {
        this.good = good;
        this.comment = comment;
        this.user = user;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", good=" + good +
                ", comment='" + comment + '\'' +
                ", user=" + user +
                '}';
    }
}
