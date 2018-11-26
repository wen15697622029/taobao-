package com.w.controller;

import com.w.model.BuyCar;
import com.w.service.BuyCarService;
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
 * Created by destiny on 2018/7/6/0006.
 */
@WebServlet(name = "DeleteBuyCarServlet",urlPatterns = "/deleteBuyCar")
public class DeleteBuyCarServlet extends HttpServlet {
    private BuyCarService buyCarService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        buyCarService = (BuyCarService) context.getBean("buyCarServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int buyCarPage=Integer.parseInt(request.getParameter("buyCarPage"));;
        int id = Integer.parseInt(request.getParameter("id"));
        BuyCar buyCar=new BuyCar(id);
        buyCarService.deleteBuyCar(buyCar);
        response.sendRedirect("buyCar");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
