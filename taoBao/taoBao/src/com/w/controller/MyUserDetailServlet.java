package com.w.controller;

import com.w.model.User;
import com.w.model.UserDetail;
import com.w.service.UserDetailService;
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
 * Created by destiny on 2018/7/5/0005.
 */
@WebServlet(name = "MyUserDetailServlet",urlPatterns = "/myUserDetail")
public class MyUserDetailServlet extends HttpServlet {
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
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        List<UserDetail> userDetails = userDetailService.getUserDetailByUser(user);
        int pageSize = 8;
        int currentPage=1;
        if(request.getAttribute("currentPage")!=null){
            currentPage = (int) request.getAttribute("currentPage");
        }
        int totalRows  = userDetails.size();
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        List<UserDetail> userDetailList = userDetailService.queryCurrentPageUserDetailByUser(user,currentPage,pageSize);
        httpSession.setAttribute("totalPages",totalPages);
        httpSession.setAttribute("currentPage",currentPage);
        httpSession.setAttribute("userDetailList",userDetailList);
        response.sendRedirect("myUserDetail.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
