package com.w.dao;

import com.w.model.Orders;
import com.w.model.User;

import java.util.List;

/**
 * Created by destiny on 2018/7/7/0007.
 */
public interface OrdersDao {

    boolean addOrders(Orders orders);

    Orders getOrdersById(Orders orders);

    boolean updateOrders(Orders orders);

    List<Orders> getOrdersByUserStateDelivery(User user, int state, int delivery);

    List<Orders> getOrdersByStateDelivery(int state, int delivery);

    List<Orders> getOrdersByUser(User user);

    boolean deleteOrders(Orders orders);
}
