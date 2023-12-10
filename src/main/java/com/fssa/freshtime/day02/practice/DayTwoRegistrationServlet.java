package com.fssa.freshtime.day02.practice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DayTwoRegistrationServlet")
public class DayTwoRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		boolean isValid = true;

		// Basic validation
		if (username == null || username.trim().isEmpty()) {
			out.println("<h2>Error: Invalid Username</h2>");
			isValid = false;
		}

		if (password == null || password.trim().isEmpty()) {
			out.println("<h2>Error: Invalid Password</h2>");
			isValid = false;
		}

		if (email == null || email.trim().isEmpty() || !email.contains("@")) {
			out.println("<h2>Error: Invalid Email</h2>");
			isValid = false;
		}

		if (isValid) {
			out.println("<h1>Success</h1>");
		}

		out.close();
	}
}
