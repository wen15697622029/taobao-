package com.w.controller;

import com.w.model.Good;
import com.w.service.GoodService;
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
 * Created by destiny on 2018/6/30/0030.
 */
@WebServlet(name = "XJGoodServlet",urlPatterns = "/xjGood")
public class XJGoodServlet extends HttpServlet {
    private GoodService goodService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        goodService = (GoodService) context.getBean("goodServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int gid = Integer.parseInt(request.getParameter("gid"));
        Good good = goodService.getGoodById(new Good(gid));
        good.setState(0);
        goodService.updateGood(good);
        response.sendRedirect("xjAdmin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
