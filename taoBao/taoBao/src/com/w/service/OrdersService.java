package com.w.service;

import com.w.model.Orders;
import com.w.model.User;

import java.util.List;

/**
 * Created by destiny on 2018/7/7/0007.
 */
public interface OrdersService {

    boolean addOrders(Orders orders);

    Orders getOrdersById(Orders orders);

    boolean updateOrders(Orders orders);

    List<Orders> getOrdersByUserStateDelivery(User user, int state, int delivery);

    List<Orders> queryCurrentPageOrdersByUserStateDelivery(User user, int state, int delivery, int currentPage, int pageSize);

    List<Orders> getOrdersByStateDelivery(int state, int delivery);

    List<Orders> queryCurrentPageOrdersByStateDelivery(int state, int delivery, int currentPage, int pageSize);

    List<Orders> getOrdersByUser(User user);

    List<Orders> queryCurrentPageOrdersByUser(User user, int currentPage, int pageSize);

    boolean deleteOrders(Orders orders);
}
