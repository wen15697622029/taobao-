package com.w.controller;

import com.w.model.User;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by destiny on 2018/7/5/0005.
 */
@WebServlet(name = "AlterUserDetailServlet",urlPatterns = "/alterUserDetail")
public class AlterUserDetailServlet extends HttpServlet {
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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        String receiver= request.getParameter("receiver");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        UserDetail userDetail = new UserDetail(id,receiver,phone,address,user);
        userDetailService.updateUserDetail(userDetail);
        response.sendRedirect("myUserDetail");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
