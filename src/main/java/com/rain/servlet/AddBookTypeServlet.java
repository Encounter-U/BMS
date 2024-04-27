package com.rain.servlet;

import com.rain.dao.TypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加书籍种类
 */
@WebServlet("/AddBookTypeServlet")
public class AddBookTypeServlet extends HttpServlet
    {
        private static final long serialVersionUID = 1L;

        public AddBookTypeServlet()
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
                // 获取图书分类的名称
                String name = request.getParameter("name");
                TypeDao typedao = new TypeDao();
                // 调用函数存入图书分类信息
                typedao.addBookType(name);
                response.sendRedirect("admin_booktype.jsp");
            }

    }
