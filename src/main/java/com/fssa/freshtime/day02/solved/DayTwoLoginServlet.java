package com.fssa.freshtime.day02.solved;

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
@WebServlet("/day02solvedlogin")
public class DayTwoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();
		if (email == null || "".equals(email)) {
			out.println("Invalid Email");
		}

		else if (password == null || "".equals(password) || password.length() < 6) {
			out.println("Invalid password");
		} else {
			out.println("Email and password is valid");
		}
	}

}
