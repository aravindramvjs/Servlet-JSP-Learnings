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
 * Servlet implementation class DayThreeRegistrationServlet
 */
@WebServlet("/DayThreeRegistrationServlet")
public class DayThreeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String LOGIN_HREF = "day03/practice/login.html";
	public static final String REGISTER_HREF = "day03/practice/register.html";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		boolean isValid = true;

		if (username == null || username.trim().isEmpty()) {
			isValid = false;
		}

		if (password == null || password.trim().isEmpty() || password.length() < 8) {
			isValid = false;
		}

		if (email == null || email.trim().isEmpty() || !email.contains("@")) {
			isValid = false;
		}

		if (isValid) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN_HREF);
			dispatcher.forward(request, response);
		} else {

			response.sendRedirect(REGISTER_HREF);
		}
		out.close();
	}

}
