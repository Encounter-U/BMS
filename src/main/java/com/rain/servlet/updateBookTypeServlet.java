package com.rain.servlet;

import com.rain.dao.TypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改图书种类信息
 */
@WebServlet("/updateBookTypeServlet")
public class updateBookTypeServlet extends HttpServlet
    {
        private static final long serialVersionUID = 1L;

        public updateBookTypeServlet()
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
                // 修改图书类型信息
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                String name = request.getParameter("name");
                int tid = Integer.parseInt(request.getParameter("tid"));
                TypeDao typedao = new TypeDao();
                typedao.updateTypeBook(tid, name);
                response.sendRedirect("admin_booktype.jsp");
            }

    }
