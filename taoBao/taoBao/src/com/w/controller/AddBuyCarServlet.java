package com.w.controller;

import com.w.model.BuyCar;
import com.w.model.Good;
import com.w.model.User;
import com.w.service.BuyCarService;
import com.w.service.GoodService;
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
 * Created by destiny on 2018/7/5/0005.
 */
@WebServlet(name = "AddBuyCarServlet",urlPatterns = "/addBuyCar")
public class AddBuyCarServlet extends HttpServlet {
    private BuyCarService buyCarService = null;
    private GoodService goodService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        buyCarService = (BuyCarService) context.getBean("buyCarServiceImpl");
        goodService = (GoodService) context.getBean("goodServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int gid = Integer.parseInt(request.getParameter("gid"));
        int gcount = Integer.parseInt(request.getParameter("gcount"));
        Good good = goodService.getGoodById(new Good(gid));
        BuyCar buyCar = new BuyCar(user,good,gcount);
        buyCarService.addBuyCar(buyCar);
        response.sendRedirect("user");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
