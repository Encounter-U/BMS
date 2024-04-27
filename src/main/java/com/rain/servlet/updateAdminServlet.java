package com.rain.servlet;

import com.rain.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改管理员信息
 */
@WebServlet("/updateAdminServlet")
public class updateAdminServlet extends HttpServlet
    {
        private static final long serialVersionUID = 1L;

        public updateAdminServlet()
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
                // 修改读者的信息
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                int aid = Integer.parseInt(request.getParameter("aid"));
                AdminDao userdao = new AdminDao();
                userdao.updateAdmin(aid, username, password, name, email, phone);
                response.sendRedirect("admin_admin.jsp");
            }

    }
