package com.w.model;

import java.io.Serializable;

/**
 * Created by destiny on 2018/7/5/0005.
 */
public class BuyCar implements Serializable{
    private int id;
    private User user;
    private Good good;
    private int gcount;

    public BuyCar(int id) {
        this.id = id;
    }

    public BuyCar(User user) {
        this.user = user;
    }

    public BuyCar(User user, Good good, int gcount) {
        this.user = user;
        this.good = good;
        this.gcount = gcount;
    }

    public BuyCar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public int getGcount() {
        return gcount;
    }

    public void setGcount(int gcount) {
        this.gcount = gcount;
    }

    @Override
    public String toString() {
        return "BuyCar{" +
                "id=" + id +
                ", user=" + user +
                ", good=" + good +
                ", gcount=" + gcount +
                '}';
    }
}
