package com.rain.servlet;

import com.rain.dao.ProblemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除反馈信息
 */
@WebServlet("/deleteProblemServlet")
public class deleteProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deleteProblemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 删除反馈信息
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int pid = Integer.parseInt(request.getParameter("pid"));
		ProblemDao problemdao = new ProblemDao();
		problemdao.deleteProblem(pid);
		response.sendRedirect("admin_feedback.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
