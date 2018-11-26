package com.w.model;

import java.io.Serializable;

/**
 * Created by destiny on 2018/7/4/0004.
 */
public class Stock implements Serializable{//ÐéÄâ¿â´æ
    private int id;
    private Good good;
    private int gcount;

    public Stock(Good good, int gcount) {
        this.good = good;
        this.gcount = gcount;
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

    public int getGcount() {
        return gcount;
    }

    public void setGcount(int gcount) {
        this.gcount = gcount;
    }

    public Stock() {
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", good=" + good +
                ", gcount=" + gcount +
                '}';
    }
}
