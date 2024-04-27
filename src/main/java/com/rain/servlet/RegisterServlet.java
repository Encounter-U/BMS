package com.rain.servlet;

import com.rain.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet
    {
        private static final long serialVersionUID = 1L;

        public RegisterServlet()
            {
                super();
            }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
            {
                this.doPost(request, response);
            }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
            {
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                // 获取注册信息
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                int lend_num = 30;
                int max_num = 5;
                AdminDao userdao = new AdminDao();
                // 将注册信息存入数据库，再返回登录
                userdao.Register(username, password, name, email, phone, lend_num, max_num);
                response.sendRedirect("login.jsp");

            }

    }
