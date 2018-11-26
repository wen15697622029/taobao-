package com.w.controller;

import com.w.model.StockRecord;
import com.w.service.StockRecordService;
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
 * Created by destiny on 2018/6/30/0030.
 */
@WebServlet(name = "SFHOrdersServlet",urlPatterns = "/sfhOrders")
public class SFHOrdersServlet extends HttpServlet {
    private StockRecordService stockRecordService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        stockRecordService = (StockRecordService) context.getBean("stockRecordServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int pageSize = 10;
        HttpSession session = request.getSession();
        int currentPage=1;
        if (request.getParameter("currentPage")!=null){
            currentPage=Integer.parseInt(request.getParameter("currentPage"));
        }
        List<StockRecord> stockRecords = stockRecordService.getStockRecord();
        int totalRows  = stockRecords.size();
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        List<StockRecord> stockRecordList = stockRecordService.queryCurrentPageStockRecord(currentPage,pageSize);
        session.setAttribute("stockRecordList",stockRecordList);
        session.setAttribute("currentPage",currentPage);
        session.setAttribute("totalPages",totalPages);
        response.sendRedirect("sfhOrders.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
