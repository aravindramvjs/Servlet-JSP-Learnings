package com.fssa.freshtime.day04.practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DayFourPracticeLogoutServlet")
public class DayFourPracticeLogoutServlet extends HttpServlet {

	public static final String LOGIN_HREF = "day04/practice/login.html";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false); // Get existing session if it exists
		if (session != null) {
			session.invalidate(); // Invalidate the session (log out the user)
		}
		response.sendRedirect(LOGIN_HREF);
	}
}
