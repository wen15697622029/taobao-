package com.w.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by destiny on 2018/7/4/0004.
 */
public class Good implements Serializable{
    private int id;
    private String name;
    private Double price;
    private String type;
    private String description;
    private String factory;
    private int state;
    private Stock stock;
    private RealStock realStock;
    private Set<BuyCar> buyCars = new HashSet<>();
    private Set<Orders> orders = new HashSet<>();
    private Set<Comment> comments = new HashSet<>();
    private Set<StockRecord> stockRecords = new HashSet<>();

    public Good(int id) {
        this.id = id;
    }

    public Set<StockRecord> getStockRecords() {
        return stockRecords;
    }

    public void setStockRecords(Set<StockRecord> stockRecords) {
        this.stockRecords = stockRecords;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public RealStock getRealStock() {
        return realStock;
    }

    public void setRealStock(RealStock realStock) {
        this.realStock = realStock;
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

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", factory='" + factory + '\'' +
                ", state=" + state +
                '}';
    }

    public Good(String name, Double price, String type, String description, String factory) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.factory = factory;
    }

    public Good() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (name != null ? !name.equals(good.name) : good.name != null) return false;
        if (price != null ? !price.equals(good.price) : good.price != null) return false;
        return factory != null ? factory.equals(good.factory) : good.factory == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (factory != null ? factory.hashCode() : 0);
        return result;
    }
}
