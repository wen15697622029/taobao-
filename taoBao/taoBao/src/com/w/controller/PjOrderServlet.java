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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by destiny on 2018/6/30/0030.
 */
@WebServlet(name = "PjOrderServlet",urlPatterns = "/pjOrder")
public class PjOrderServlet extends HttpServlet {
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
        int pjOrdersId = Integer.parseInt(request.getParameter("pjOrdersId"));
        Orders orders = ordersService.getOrdersById(new Orders(pjOrdersId));
        HttpSession session = request.getSession();
        session.setAttribute("pjOrders",orders);
        response.sendRedirect("pjOrders.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
