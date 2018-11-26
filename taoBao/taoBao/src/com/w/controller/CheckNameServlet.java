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
import java.io.IOException;

/**
 * Created by destiny on 2018/7/4/0004.
 */
@WebServlet(name = "CheckNameServlet",urlPatterns = "/checkName")
public class CheckNameServlet extends HttpServlet {
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
        System.out.println("dd");
        String name = request.getParameter("name");
        System.out.println(name);
        User user = new User(name);
        User user1 = userService.getUserByName(user);
        System.out.println(user1);
        if (user1==null){
            response.getWriter().print("可以注册");
        }else{
            response.getWriter().print("已有该用户");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
