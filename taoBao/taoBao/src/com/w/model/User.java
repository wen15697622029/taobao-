package com.w.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by destiny on 2018/7/4/0004.
 */
public class User implements Serializable{
    private int id;
    private String name;
    private String pass;
    private String sex;
    private Double money;
    private Set<UserDetail> userDetails = new HashSet<>();
    private Set<BuyCar> buyCars = new HashSet<>();
    private Set<Orders> orders = new HashSet<>();
    private Set<Comment> comments = new HashSet<>();

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Set<BuyCar> getBuyCars() {
        return buyCars;
    }

    public void setBuyCars(Set<BuyCar> buyCars) {
        this.buyCars = buyCars;
    }

    public Set<UserDetail> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Set<UserDetail> userDetails) {
        this.userDetails = userDetails;
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String pass, String sex) {
        this.name = name;
        this.pass = pass;
        this.sex = sex;
        this.money = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", sex='" + sex + '\'' +
                ", money=" + money +
                '}';
    }
}
