package com.w.controller;

import com.w.model.Good;
import com.w.service.GoodService;
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
@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
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
        int pageSize = 10;
        HttpSession session = request.getSession();
        int currentPage=1;
        if (request.getParameter("currentPage")!=null){
            currentPage=Integer.parseInt(request.getParameter("currentPage"));
        }
        List<Good> goodList = goodService.getGood();
        int totalRows  = goodList.size();
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        List<Good> goods = goodService.queryCurrentPageGood(currentPage,pageSize);
        session.setAttribute("goods",goods);
        session.setAttribute("currentPage",currentPage);
        session.setAttribute("totalPages",totalPages);
        response.sendRedirect("admin.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
