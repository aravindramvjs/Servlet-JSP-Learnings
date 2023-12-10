package com.fssa.freshtime.day03.practice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DayThreeLoginServlet
 */
@WebServlet("/DayThreePracticeLoginServlet")
public class DayThreePracticeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String LOGIN_HREF = "day03/practice/login.html";
	public static final String HOME_HREF = "day03/practice/home.html";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String regEmail = request.getParameter("email");
		String regPassword = request.getParameter("password");

		String loginEmail = request.getParameter("login_email");
		String loginPassword = request.getParameter("login_password");

		if (regEmail.equals(loginEmail) && (regPassword.endsWith(loginPassword))) {

			RequestDispatcher dispatcher = request.getRequestDispatcher(HOME_HREF);
			dispatcher.forward(request, response);

		} else {

			response.sendRedirect(LOGIN_HREF);

		}

		out.close();

	}

}
