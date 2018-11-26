package com.w.controller;

import com.w.model.Orders;
import com.w.model.UserDetail;
import com.w.service.OrdersService;
import com.w.service.StockService;
import com.w.service.UserDetailService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by destiny on 2018/7/7/0007.
 */
@WebServlet(name = "XDOrdersServlet",urlPatterns = "/xdOrders")
public class XDOrdersServlet extends HttpServlet {
    private StockService stockService = null;
    private OrdersService ordersService = null;
    private UserDetailService userDetailService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        stockService = (StockService) context.getBean("stockServiceImpl");
        ordersService = (OrdersService) context.getBean("ordersServiceImpl");
        userDetailService = (UserDetailService) context.getBean("userDetailServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int udid = Integer.parseInt(request.getParameter("udid"));
        UserDetail userDetail = userDetailService.getUserDetailById(new UserDetail(udid));
        HttpSession session = request.getSession();
        Orders orders = (Orders) session.getAttribute("orders");
        orders.setUserDetail(userDetail);
        ordersService.addOrders(orders);
        response.sendRedirect("user");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
