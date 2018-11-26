package com.w.controller;

import com.w.model.Orders;
import com.w.model.StockRecord;
import com.w.service.OrdersService;
import com.w.service.StockRecordService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by destiny on 2018/7/1/0001.
 */
@WebServlet(name = "FHOrdersServlet",urlPatterns = "/fhOrders")
public class FHOrdersServlet extends HttpServlet {
    private OrdersService ordersService = null;
    private StockRecordService stockRecordService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        ordersService = (OrdersService) context.getBean("ordersServiceImpl");
        stockRecordService = (StockRecordService) context.getBean("stockRecordServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("ordersId"));
        Orders orders = ordersService.getOrdersById(new Orders(id));
        orders.setDelivery(1);
        orders.getGood().getRealStock().setGcount(orders.getGood().getRealStock().getGcount()-orders.getGcount());
        ordersService.updateOrders(orders);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format( new Date());
        StockRecord stockRecord = new StockRecord(orders.getGood(),orders.getGcount(),time,0);
        stockRecordService.addStockRecord(stockRecord);
        response.sendRedirect("sfhOrders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
