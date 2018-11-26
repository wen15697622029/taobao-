package com.w.model;

import java.io.Serializable;

/**
 * Created by destiny on 2018/7/8/0008.
 */
public class Admin implements Serializable{
    private int id;
    private String name;
    private String password;

    public Admin(String name) {
        this.name = name;
    }

    public Admin(int id) {
        this.id = id;
    }

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Admin() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
