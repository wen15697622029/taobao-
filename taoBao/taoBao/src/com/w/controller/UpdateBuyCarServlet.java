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
 * Created by destiny on 2018/7/5/0005.
 */
@WebServlet(name = "UpdateBuyCarServlet",urlPatterns = "/updateBuyCar")
public class UpdateBuyCarServlet extends HttpServlet {
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
        int gcount = Integer.parseInt(request.getParameter("gcount"));
        int id = Integer.parseInt(request.getParameter("id"));
        BuyCar buyCar = buyCarService.getBuyCarById(new BuyCar(id));
        buyCar.setGcount(gcount);
        buyCarService.updateBuyCar(buyCar);
        response.sendRedirect("buyCar");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
