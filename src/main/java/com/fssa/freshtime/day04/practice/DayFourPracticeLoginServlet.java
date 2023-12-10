package com.fssa.freshtime.day04.practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DayFourPracticeLoginServlet")
public class DayFourPracticeLoginServlet extends HttpServlet {

	public static final String BOOKINGPAGE_HREF = "day04/practice/BookingPage.jsp";
	public static final String LOGIN_HREF = "day04/practice/login.html";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ("user123".equals(username) && "password123".equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", username);
			session.setMaxInactiveInterval(20); // Set session timeout to 10 seconds
			response.sendRedirect(BOOKINGPAGE_HREF);
		} else {
			response.sendRedirect(LOGIN_HREF);
		}
	}
}