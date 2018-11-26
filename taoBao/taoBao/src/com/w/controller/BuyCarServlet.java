package com.w.controller;

import com.w.model.BuyCar;
import com.w.model.User;
import com.w.model.UserDetail;
import com.w.service.BuyCarService;
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
@WebServlet(name = "BuyCarServlet",urlPatterns = "/buyCar")
public class BuyCarServlet extends HttpServlet {
    private BuyCarService buyCarService = null;
    private UserDetailService userDetailService = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        buyCarService = (BuyCarService) context.getBean("buyCarServiceImpl");
        userDetailService = (UserDetailService) context.getBean("userDetailServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<BuyCar> buyCarList = buyCarService.getBuyCarByUser(user);
        int pageSize = 9;
        int currentPage=1;
        if (request.getParameter("currentPage")!=null){
            currentPage=Integer.parseInt(request.getParameter("currentPage"));
        }
        int totalRows  = buyCarList.size();
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        if(currentPage>totalPages){//当请求页数大于总页数
            currentPage=totalPages;
        }
        List<BuyCar> buyCars = buyCarService.queryCurrentPageBuyCarByUser(user,currentPage,pageSize);
        List<UserDetail> userDetails = userDetailService.getUserDetailByUser(user);
        session.setAttribute("userDetails",userDetails);
        session.setAttribute("buyCars",buyCars);
        session.setAttribute("currentPage",currentPage);
        session.setAttribute("totalPages",totalPages);
        response.sendRedirect("buyCar.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
