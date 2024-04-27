package com.rain.servlet;

import com.rain.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加读者
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet
    {
        private static final long serialVersionUID = 1L;

        public AddUserServlet()
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
                // 设置编码类型
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                // 获取要添加的读者的信息
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                int lend_num = Integer.parseInt(request.getParameter("lend_num"));
                int max_num = Integer.parseInt(request.getParameter("max_num"));

                AdminDao userdao = new AdminDao();
                // 调用函数添加读者信息
                userdao.Register(username, password, name, email, phone, lend_num, max_num);
                response.sendRedirect("admin_user.jsp");
            }

    }
