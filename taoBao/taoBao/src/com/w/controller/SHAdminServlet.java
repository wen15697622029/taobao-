package com.w.controller;

import com.w.model.Good;
import com.w.model.RealStock;
import com.w.model.Stock;
import com.w.model.StockRecord;
import com.w.service.GoodService;
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
 * Created by destiny on 2018/6/30/0030.
 */
@WebServlet(name = "SHAdminServlet",urlPatterns = "/shAdmin")
public class SHAdminServlet extends HttpServlet{
        private GoodService goodService = null;
        private StockRecordService stockRecordService = null;
        @Override
        public void init(ServletConfig config) throws ServletException {
            ApplicationContext context =
                    WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
            goodService = (GoodService) context.getBean("goodServiceImpl");
            stockRecordService = (StockRecordService) context.getBean("stockRecordServiceImpl");
        }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String factory = request.getParameter("factory");
        int gcount = Integer.parseInt(request.getParameter("gcount"));
        Good good = new Good(name,price,type,description,factory);
        Good good1 = goodService.getGoodByNamePriceFactory(good);
        if (good1==null){
            good.setStock(new Stock());
            good.setRealStock(new RealStock());
            good.getStock().setGcount(0);
            good.getStock().setGood(good);
            good.getRealStock().setGcount(0);
            good.getRealStock().setGood(good);
            goodService.addGood(good);
            good1 = goodService.getGoodByNamePriceFactory(good);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format( new Date());
        StockRecord stockRecord = new StockRecord(good1,gcount,time,1);
        stockRecordService.addStockRecord(stockRecord);
        good1.getRealStock().setGcount(good1.getRealStock().getGcount()+gcount);
        good1.getStock().setGcount(good1.getStock().getGcount()+gcount);
        goodService.updateGood(good1);
        response.sendRedirect("sfhOrders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
