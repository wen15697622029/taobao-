package com.w.controller;

import com.w.model.UserDetail;
import com.w.service.UserDetailService;
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
@WebServlet(name = "DelUserDetailServlet",urlPatterns = "/delUserDetail")
public class DelUserDetailServlet extends HttpServlet {
    private UserDetailService userDetailService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        userDetailService = (UserDetailService) context.getBean("userDetailServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int id =Integer.parseInt(request.getParameter("id"));
        boolean falg = userDetailService.deleteUserDetail(new UserDetail(id));
        if (falg){
            response.sendRedirect("myUserDetail");
        }else{
            request.setAttribute("error2","改地址使用中，不能删除");
            request.getRequestDispatcher("myUserDetail.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
