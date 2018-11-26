package com.w.controller;

import com.w.model.Good;
import com.w.model.Orders;
import com.w.model.User;
import com.w.model.UserDetail;
import com.w.service.GoodService;
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
import java.util.List;

/**
 * Created by destiny on 2018/7/7/0007.
 */
@WebServlet(name = "AddOrdersServlet",urlPatterns = "/addOrders")
public class AddOrdersServlet extends HttpServlet {
    private GoodService goodService = null;
    private UserDetailService userDetailService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        goodService = (GoodService) context.getBean("goodServiceImpl");
        userDetailService = (UserDetailService) context.getBean("userDetailServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int gid = Integer.parseInt(request.getParameter("gid"));
        int gcount = Integer.parseInt(request.getParameter("gcount"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Good good = goodService.getGoodById(new Good(gid));
        Orders orders = new Orders(user,good,gcount*good.getPrice(),0,gcount,0);
        List<UserDetail> userDetails = userDetailService.getUserDetailByUser(user);
        session.setAttribute("userDetails",userDetails);
        session.setAttribute("orders",orders);
        response.sendRedirect("chooseUD.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
