package com.rain.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理员登陆,进入之后可对管理员账号进行管理
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet
    {
        private static final long serialVersionUID = 1L;

        public AdminLoginServlet()
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
                // 获取账号和密码
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if (username.equals("DongXin") && password.equals("dx123456"))
                    {
                        response.sendRedirect("admin_admin.jsp");
                    }
                else
                    {
                        HttpSession session = request.getSession();
                        session.setAttribute("state", "密码错误");
                        response.sendRedirect("admin_login.jsp");
                    }
            }

    }
