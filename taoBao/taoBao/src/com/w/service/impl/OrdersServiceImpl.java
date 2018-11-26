package com.w.service.impl;

import com.w.dao.OrdersDao;
import com.w.model.Orders;
import com.w.model.Stock;
import com.w.model.User;
import com.w.service.OrdersService;
import com.w.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2018/7/7/0007.
 */
@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    private OrdersDao ordersDao = null;
    @Autowired
    private StockService stockService = null;
    @Override
    public boolean addOrders(Orders orders) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format( new Date());
        orders.setTime(time);
        if (orders.getUser().getMoney()>=orders.getMoney()){
            orders.getUser().setMoney(orders.getUser().getMoney()-orders.getMoney());
            orders.setState(1);
        }
        Stock stock = orders.getGood().getStock();
        stock.setGcount(stock.getGcount()-orders.getGcount());
        stockService.updateStock(stock);
        ordersDao.addOrders(orders);
        return true;
    }

    @Override
    public Orders getOrdersById(Orders orders) {
        return ordersDao.getOrdersById(orders);
    }

    @Override
    public boolean updateOrders(Orders orders) {
        return ordersDao.updateOrders(orders);
    }

    @Override
    public List<Orders> getOrdersByUserStateDelivery(User user, int state, int delivery) {
        return ordersDao.getOrdersByUserStateDelivery(user,state,delivery);
    }

    @Override
    public List<Orders> queryCurrentPageOrdersByUserStateDelivery(User user, int state, int delivery, int currentPage, int pageSize) {
        List<Orders> orders = getOrdersByUserStateDelivery(user,state,delivery);
        int begin = (currentPage-1)*pageSize;
        int end = pageSize;
        List<Orders> ordersList = new ArrayList<>();
        for (int i = begin; !orders.isEmpty()&&(i<begin+end)&&i <orders.size() ; i++) {
            ordersList.add(orders.get(i));
        }
        return ordersList;
    }

    @Override
    public List<Orders> getOrdersByStateDelivery(int state, int delivery) {
        return ordersDao.getOrdersByStateDelivery(state,delivery);
    }

    @Override
    public List<Orders> queryCurrentPageOrdersByStateDelivery(int state, int delivery, int currentPage, int pageSize) {
        List<Orders> orders = getOrdersByStateDelivery(state,delivery);
        int begin = (currentPage-1)*pageSize;
        int end = pageSize;
        List<Orders> ordersList = new ArrayList<>();
        for (int i = begin; !orders.isEmpty()&&(i<begin+end)&&i <orders.size() ; i++) {
            ordersList.add(orders.get(i));
        }
        return ordersList;
    }

    @Override
    public List<Orders> getOrdersByUser(User user) {
        return ordersDao.getOrdersByUser(user);
    }

    @Override
    public List<Orders> queryCurrentPageOrdersByUser(User user, int currentPage, int pageSize) {
        List<Orders> orders = getOrdersByUser(user);
        int begin = (currentPage-1)*pageSize;
        int end = pageSize;
        List<Orders> ordersList = new ArrayList<>();
        for (int i = begin; !orders.isEmpty()&&(i<begin+end)&&i <orders.size() ; i++) {
            ordersList.add(orders.get(i));
        }
        return ordersList;
    }

    @Override
    public boolean deleteOrders(Orders orders) {
        return ordersDao.deleteOrders(orders);
    }
}
