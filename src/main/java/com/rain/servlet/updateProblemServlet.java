package com.rain.servlet;

import com.rain.dao.ProblemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改状态信息
 */
@WebServlet("/updateProblemServlet")
public class updateProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateProblemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 修改反馈问题状态
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String status = request.getParameter("status");
		int pid = Integer.parseInt(request.getParameter("pid"));
		ProblemDao problemdao = new ProblemDao();
		problemdao.updateProblem(pid, status);
		response.sendRedirect("admin_feedback.jsp");
	}

}
