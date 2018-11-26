package com.w.controller;

import com.w.model.*;
import com.w.service.*;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2018/6/29/0029.
 */
@WebServlet(name = "BuyCarXDServlet",urlPatterns = "/buyCarXD")
public class BuyCarXDServlet extends HttpServlet {
    private BuyCarService buyCarService = null;
    private UserService userService = null;
    private StockService stockService = null;
    private OrdersService ordersService = null;
    private UserDetailService userDetailService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        buyCarService = (BuyCarService) context.getBean("buyCarServiceImpl");
        userService = (UserService) context.getBean("userServiceImpl");
        stockService = (StockService) context.getBean("stockServiceImpl");
        ordersService = (OrdersService) context.getBean("ordersServiceImpl");
        userDetailService = (UserDetailService) context.getBean("userDetailServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String buyCarIDs = request.getParameter("buyCarIDs");
        int udid=Integer.parseInt(request.getParameter("udid"));
        UserDetail userDetail = userDetailService.getUserDetailById(new UserDetail(udid));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String [] buyCarIDs1 = buyCarIDs.split(",");
        List<Orders> ordersList = new ArrayList<>();
        for (int i = 0; i < buyCarIDs1.length; i++) {
            int buyCarId=Integer.parseInt(buyCarIDs1[i]);
            BuyCar buyCar = buyCarService.getBuyCarById(new BuyCar(buyCarId));
            Good good = buyCar.getGood();
            Stock stock = good.getStock();
            stock.setGcount(stock.getGcount()-buyCar.getGcount());
            stockService.updateStock(stock);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=sdf.format( new Date());
            Orders orders = new Orders(user,good,userDetail,time,buyCar.getGcount()*good.getPrice(),0,buyCar.getGcount(),0);
            ordersList.add(orders);
        }
        Double money1 = Double.parseDouble(request.getParameter("money1"));
        if (money1<user.getMoney()){
            user.setMoney(user.getMoney()-money1);
            userService.updateUser(user);
            session.setAttribute("user",user);
            for (int i = 0; i <ordersList.size() ; i++) {
                ordersList.get(i).setState(1);
            }
        }
        for (int i = 0; i <ordersList.size() ; i++) {
            ordersService.addOrders(ordersList.get(i));
        }
        for (int i = 0; i < buyCarIDs1.length; i++) {
            int buyCarId=Integer.parseInt(buyCarIDs1[i]);
            buyCarService.deleteBuyCar(new BuyCar(buyCarId));
        }
        response.sendRedirect("myOrders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
