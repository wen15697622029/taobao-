package com.w.controller;

import com.w.model.Good;
import com.w.model.Orders;
import com.w.model.Stock;
import com.w.service.OrdersService;
import com.w.service.StockService;
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
 * Created by destiny on 2018/7/2/0002.
 */
@WebServlet(name = "TYAdminServlet",urlPatterns = "/tyAdmin")
public class TYAdminServlet extends HttpServlet {
    private StockService stockService = null;
    private OrdersService ordersService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        stockService = (StockService) context.getBean("stockServiceImpl");
        ordersService = (OrdersService) context.getBean("ordersServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int ordersId =Integer.parseInt(request.getParameter("ordersId"));
        Orders orders = ordersService.getOrdersById(new Orders(ordersId));
        orders.setState(3);
        ordersService.updateOrders(orders);
        Good good = orders.getGood();
        Stock stock = stockService.getStockByGood(good);
        stock.setGcount(stock.getGcount()+orders.getGcount());
        stockService.updateStock(stock);
        response.sendRedirect("tkAdmin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
