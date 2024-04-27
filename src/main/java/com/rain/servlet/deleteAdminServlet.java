package com.rain.servlet;

import com.rain.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除管理员信息
 */
@WebServlet("/deleteAdminServlet")
public class deleteAdminServlet extends HttpServlet
    {
        private static final long serialVersionUID = 1L;

        public deleteAdminServlet()
            {
                super();
            }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
            {
                // 删除管理员信息
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                int aid = Integer.parseInt(request.getParameter("aid"));
                AdminDao admindao = new AdminDao();
                admindao.deleteAdmin(aid);
                response.sendRedirect("admin_admin.jsp");
            }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
            {
                doGet(request, response);
            }

    }
