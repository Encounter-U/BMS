package com.rain.servlet;

import com.rain.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加图书
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet
    {
        private static final long serialVersionUID = 1L;

        public AddBookServlet()
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
                // 获取要添加图书的信息
                String card = request.getParameter("card");
                String name = request.getParameter("name");
                String type = request.getParameter("type");
                String autho = request.getParameter("autho");
                String press = request.getParameter("press");
                int num = Integer.parseInt(request.getParameter("num"));
                BookDao bookdao = new BookDao();
                // 调用函数，存入图书
                bookdao.addBook(card, name, type, autho, press, num);
                response.sendRedirect("admin_book.jsp");
            }

    }
