package com.w.controller;

import com.w.model.Orders;
import com.w.model.User;
import com.w.service.OrdersService;
import com.w.utils.DoPage;
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
import java.util.List;

/**
 * Created by destiny on 2018/7/7/0007.
 */
@WebServlet(name = "MyOrdersServlet",urlPatterns = "/myOrders")
public class MyOrdersServlet extends HttpServlet {
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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Orders> ordersList = ordersService.getOrdersByUser(user);
        int pageSize = 10;
        int currentPage=1;
        if (request.getParameter("currentPage")!=null){
            currentPage=Integer.parseInt(request.getParameter("currentPage"));
        }
        int totalRows  = ordersList.size();
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        List<Orders> orders = ordersService.queryCurrentPageOrdersByUser(user,currentPage,pageSize);

        session.setAttribute("currentPage",currentPage);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("orders",orders);
        response.sendRedirect("myOrders.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
