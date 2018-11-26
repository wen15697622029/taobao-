package com.w.controller;

import com.w.model.Comment;
import com.w.model.Orders;
import com.w.service.CommentService;
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
@WebServlet(name = "PJServlet",urlPatterns = "/pj")
public class PJServlet extends HttpServlet {
    private OrdersService ordersService = null;
    private CommentService commentService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        ordersService = (OrdersService) context.getBean("ordersServiceImpl");
        commentService = (CommentService) context.getBean("commentServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String comment = request.getParameter("comment");
        HttpSession session = request.getSession();
        Orders orders = (Orders) session.getAttribute("pjOrders");
        Comment comment1 = new Comment(orders.getGood(),comment,orders.getUser());
        commentService.addComment(comment1);
        orders.setDelivery(3);
        ordersService.updateOrders(orders);
        response.sendRedirect("myOrders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
