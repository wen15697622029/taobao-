package com.w.controller;

import com.w.model.Orders;
import com.w.service.OrdersService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by destiny on 2018/7/8/0008.
 */
@WebServlet(name = "CxOrdersServlet",urlPatterns = "/cxOrders")
public class CxOrdersServlet extends HttpServlet {
    private OrdersService ordersService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        ordersService = (OrdersService) context.getBean("ordersServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int ordersId =Integer.parseInt(request.getParameter("ordersId"));
        Orders orders = ordersService.getOrdersById(new Orders(ordersId));
        orders.setState(1);
        ordersService.updateOrders(orders);
        response.sendRedirect("dfhOrders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
