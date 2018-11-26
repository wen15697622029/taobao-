package com.w.model;

import java.io.Serializable;

/**
 * Created by destiny on 2018/7/6/0006.
 */
public class Orders implements Serializable{
    private int id;
    private User user;
    private Good good;
    private UserDetail userDetail;
    private String time;
    private Double money;
    private int state;//0未付款1已付款2退款3退款成功
    private int gcount;
    private int delivery;//0未发货1已发货2已确认3已评价

    public Orders(int id) {
        this.id = id;
    }

    public Orders(User user, Good good, UserDetail userDetail, String time, Double money, int state, int gcount, int delivery) {
        this.user = user;
        this.good = good;
        this.userDetail = userDetail;
        this.time = time;
        this.money = money;
        this.state = state;
        this.gcount = gcount;
        this.delivery = delivery;
    }

    public Orders(User user) {
        this.user = user;
    }

    public Orders(int state, int delivery) {
        this.state = state;
        this.delivery = delivery;
    }

    public Orders(User user, Good good,Double money, int state, int gcount, int delivery) {
        this.user = user;
        this.good = good;
        this.money = money;
        this.state = state;
        this.gcount = gcount;
        this.delivery = delivery;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", user=" + user +
                ", good=" + good +
                ", userDetail=" + userDetail +
                ", time='" + time + '\'' +
                ", money=" + money +
                ", state=" + state +
                ", gcount=" + gcount +
                ", delivery=" + delivery +
                '}';
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

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getGcount() {
        return gcount;
    }

    public void setGcount(int gcount) {
        this.gcount = gcount;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }
}
