package com.w.controller;

import com.w.model.User;
import com.w.service.UserService;
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
 * Created by destiny on 2018/6/21/0021.
 */
@WebServlet(name = "ChangePassWordServlet",urlPatterns = "/changePassword")
public class ChangePassWordServlet extends HttpServlet {
    private UserService userService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        userService = (UserService) context.getBean("userServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String oldPassWord = request.getParameter("oldpassword");
        String newPassWord = request.getParameter("newpassword");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        boolean flag = userService.updatePassWord(user,oldPassWord,newPassWord);
        if (flag){
            response.sendRedirect("login.jsp");
        }else{
            request.setAttribute("error","原密码错误");
            request.getRequestDispatcher("myUserDetail.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
