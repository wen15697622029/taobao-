package com.w.controller;

import com.w.model.Orders;
import com.w.model.User;
import com.w.service.OrdersService;
import com.w.service.UserService;
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
@WebServlet(name = "PayServlet",urlPatterns = "/pay")
public class PayServlet extends HttpServlet {
    private UserService userService = null;
    private OrdersService ordersService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        userService = (UserService) context.getBean("userServiceImpl");
        ordersService = (OrdersService) context.getBean("ordersServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        int ordersId =Integer.parseInt(request.getParameter("ordersId"));
        Orders orders = ordersService.getOrdersById(new Orders(ordersId));
        User user = (User) session.getAttribute("user");
        user.setMoney(user.getMoney()-orders.getMoney());
        userService.updateUser(user);
        session.setAttribute("user",user);
        orders.setState(1);
        ordersService.updateOrders(orders);
        response.sendRedirect("myOrders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
