package com.w.dao.impl;

import com.w.dao.OrdersDao;
import com.w.model.Orders;
import com.w.model.User;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/7/0007.
 */
@Repository
public class OrdersDaoImpl implements OrdersDao{
    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean addOrders(Orders orders) {
        hibernateTemplate.merge(orders);
        return true;
    }

    @Override
    public Orders getOrdersById(Orders orders) {
        String hql = "from Orders where id = ?";
        List<Orders> ordersList = (List<Orders>) hibernateTemplate.find(hql,orders.getId());
        if (ordersList.isEmpty()){
            return null;
        }
        return ordersList.get(0);
    }

    @Override
    public boolean updateOrders(Orders orders) {
        hibernateTemplate.update(orders);
        return true;
    }

    @Override
    public List<Orders> getOrdersByUserStateDelivery(User user, int state, int delivery) {
        String hql = "from Orders where user.id = ? and state = ? and delivery = ?";
        List<Orders> orders = (List<Orders>) hibernateTemplate.find(hql,user.getId(),state,delivery);
        return orders;
    }

    @Override
    public List<Orders> getOrdersByStateDelivery(int state, int delivery) {
        String hql = "from Orders where state = ? and delivery = ?";
        List<Orders> orders = (List<Orders>) hibernateTemplate.find(hql,state,delivery);
        return orders;
    }

    @Override
    public List<Orders> getOrdersByUser(User user) {
        String hql = "from Orders where user.id = ?";
        List<Orders> orders = (List<Orders>) hibernateTemplate.find(hql,user.getId());
        return orders;
    }

    @Override
    public boolean deleteOrders(Orders orders) {
        hibernateTemplate.delete(orders);
        return true;
    }
}
