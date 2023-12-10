package com.fssa.freshtime.day04.solved;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/DayFourLoginServlet")
public class DayFourLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String LOGIN_HREF = "day04/solved/login.html";
	public static final String HOME_HREF = "day04/solved/home.html";

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
			HttpSession session = request.getSession();
			session.setAttribute("loggedInEmail", email);
			RequestDispatcher dispatcher = request.getRequestDispatcher(HOME_HREF);
			dispatcher.forward(request, response);
		}

	}

}
