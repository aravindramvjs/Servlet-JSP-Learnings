package com.fssa.freshtime.day05.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAllUserServlet
 */
@WebServlet("/DayFivePracticeGetAllUsers")
public class DayFivePracticeGetAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String DISPLAY_ALL_USERS = "/day05/practice/display_all_users.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> users = new ArrayList<User>();

		users.add(new User(1, "Bharath", "bharath@fssa.freshworks.com", "password123"));
		users.add(new User(2, "ram", "ram@fssa.freshworks.com", "ps322211"));
		users.add(new User(3, "Sridhivya", "sridhivya.freshworks.com", "sri@pass3"));
		// set the list of users in the request scope and create a display_all_users.jsp
		// file
		request.setAttribute("usersList", users);
		RequestDispatcher dis = request.getServletContext().getRequestDispatcher(DISPLAY_ALL_USERS);
		dis.forward(request, response);
		// to print the details in HTML Tabular format. DO NOT print the passwords
	}

}
