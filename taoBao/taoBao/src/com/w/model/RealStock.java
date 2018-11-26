package com.w.model;

import java.io.Serializable;

/**
 * Created by destiny on 2018/7/6/0006.
 */
public class RealStock implements Serializable{
    private int id;
    private Good good;
    private int gcount;

    public RealStock(Good good, int gcount) {
        this.good = good;
        this.gcount = gcount;
    }

    public RealStock() {
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

    @Override
    public String toString() {
        return "RealStock{" +
                "id=" + id +
                ", good=" + good +
                ", gcount=" + gcount +
                '}';
    }
}
