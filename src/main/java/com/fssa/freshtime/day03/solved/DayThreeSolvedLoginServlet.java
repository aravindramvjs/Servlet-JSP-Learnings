package com.fssa.freshtime.day03.solved;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/day03solvedlogin")
public class DayThreeSolvedLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String LOGIN_HREF = "day03/solved/login.html";
	public static final String HOME_HREF = "day03/solved/home.html";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();
		if (email == null || "".equals(email)) {
			out.println("Invalid Email");
			response.sendRedirect(LOGIN_HREF);
		}

		else if (password == null || "".equals(password) || password.length() < 6) {
			response.sendRedirect(LOGIN_HREF);
		} else {
			out.println("Email and password is valid");
			response.sendRedirect(HOME_HREF);
		}

	}

}