package com.rain.servlet;

import com.rain.bean.AdminBean;
import com.rain.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
    {
        private static final long serialVersionUID = 1L;

        public LoginServlet()
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
                String text = request.getParameter("code");
                String code = (String) request.getSession().getAttribute("code");
                PrintWriter writer=response.getWriter();
                writer.println(username);
                writer.println(password);
                writer.println(text);
                writer.println(code);

                AdminDao userdao = new AdminDao();
                // 对账号和密码进行判断
                boolean result = userdao.Login_verify(username, password);
                HttpSession session = request.getSession();
                if (code.equalsIgnoreCase(text))
                    {
                        // 判断输入正确
                        if (result)
                            {
                                AdminBean adminbean = new AdminBean();
                                AdminDao admindao = new AdminDao();
                                // 更新账号和密码查找出读者的信息
                                adminbean = admindao.getAdminInfo(username, password);
                                // 将aid存入session中
                                session.setAttribute("aid", "" + adminbean.getAid());
                                // 设置session的失效时间
                                session.setMaxInactiveInterval(6000);
                                // 根据status的值来判断是管理员，还是读者，status=1为读者
                                if (adminbean.getStatus() == 1)
                                    {
                                        response.sendRedirect("index.jsp");
                                    }
                                else
                                    {
                                        response.sendRedirect("admin.jsp");
                                    }
                            }
                        else
                            {
                                // 没有找到对应的账号和密码，返回重新登录
                                session.setAttribute("state", "密码错误");
                                response.sendRedirect("login.jsp");
                            }
                    }
                else
                    {
                        session.setAttribute("state", "验证码错误");
                        response.sendRedirect("login.jsp");
                    }
            }

    }
