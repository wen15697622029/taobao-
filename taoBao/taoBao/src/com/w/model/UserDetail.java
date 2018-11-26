package com.w.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by destiny on 2018/7/4/0004.
 */
public class UserDetail implements Serializable{
    private int id;
    private String receiver;
    private String phone;
    private String address;
    private User user;
    private Set<Orders> orders = new HashSet<>();

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public UserDetail(int id, String receiver, String phone, String address) {
        this.id = id;
        this.receiver = receiver;
        this.phone = phone;
        this.address = address;
    }

    public UserDetail(String receiver, String phone, String address, User user) {
        this.receiver = receiver;
        this.phone = phone;
        this.address = address;
        this.user = user;
    }

    public UserDetail(int id, String receiver, String phone, String address, User user) {
        this.id = id;
        this.receiver = receiver;
        this.phone = phone;
        this.address = address;
        this.user = user;
    }

    public UserDetail(String receiver, String phone, String address) {
        this.receiver = receiver;
        this.phone = phone;
        this.address = address;
    }

    public UserDetail() {
    }

    public UserDetail(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", receiver='" + receiver + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
