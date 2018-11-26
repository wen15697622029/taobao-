package com.w.controller;

import com.w.model.Admin;
import com.w.service.AdminService;
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
 * Created by destiny on 2018/6/30/0030.
 */
@WebServlet(name = "AdminLoginServlet",urlPatterns = "/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    private AdminService adminService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        adminService = (AdminService) context.getBean("adminServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Admin admin = new Admin(name,password);
        int num = adminService.adminLogin(admin);
        if (num==0){
            request.setAttribute("error","该管理员不存在");
            request.getRequestDispatcher("adminLogin.jsp").forward(request,response);
            return;
        }
        if (num==1){
            HttpSession session = request.getSession();
            session.setAttribute("admin",admin);
            response.sendRedirect("admin");
        }else{
            request.setAttribute("error","密码错误");
            request.getRequestDispatcher("adminLogin.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
