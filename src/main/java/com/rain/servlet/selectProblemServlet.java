package com.rain.servlet;

import com.rain.bean.ProblemBean;
import com.rain.dao.ProblemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 根据问题名查询反馈问题
 */
@WebServlet("/selectProblemServlet")
public class selectProblemServlet extends HttpServlet
    {
        private static final long serialVersionUID = 1L;

        public selectProblemServlet()
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
                String name = request.getParameter("name");
                ProblemDao problemdao = new ProblemDao();
                ArrayList<ProblemBean> data = problemdao.getLikeList(name);
                // 将获取的结果存入请求中
                request.setAttribute("data", data);
                String url = "";
                // 转发界面
                url = response.encodeURL("admin_feedback.jsp");
                // 将请求转发
                request.getRequestDispatcher(url).forward(request, response);
            }

    }
