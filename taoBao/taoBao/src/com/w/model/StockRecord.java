package com.w.model;

/**
 * Created by destiny on 2018/7/6/0006.
 */
public class StockRecord {
    private int id;
    private Good good;
    private int gcount;
    private String time;
    private int state;//1Èë¿â0³ö¿â

    public StockRecord(Good good, int gcount, String time, int state) {
        this.good = good;
        this.gcount = gcount;
        this.time = time;
        this.state = state;
    }

    public StockRecord(Good good, int gcount, int state) {
        this.good = good;
        this.gcount = gcount;
        this.state = state;
    }

    public StockRecord() {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "StockRecord{" +
                "id=" + id +
                ", good=" + good +
                ", gcount=" + gcount +
                ", time='" + time + '\'' +
                ", state=" + state +
                '}';
    }
}
