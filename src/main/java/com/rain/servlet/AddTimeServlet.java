package com.rain.servlet;

import com.rain.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 延期归还
 */
@WebServlet("/AddTimeServlet")
public class AddTimeServlet extends HttpServlet
    {
        private static final long serialVersionUID = 1L;

        public AddTimeServlet()
            {
                super();
            }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
            {
                doPost(request, response);
            }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
            {
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                String endtime = request.getParameter("endtime");
                int hid = Integer.parseInt(request.getParameter("hid"));
                BookDao bookdao = new BookDao();
                bookdao.AddTime(hid, endtime);
                response.sendRedirect("admin_borrow.jsp");
            }

    }
