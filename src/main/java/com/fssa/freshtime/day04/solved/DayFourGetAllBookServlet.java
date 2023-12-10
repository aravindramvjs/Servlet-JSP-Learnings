package com.fssa.freshtime.day04.solved;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Servlet implementation class GetAllBookServlet
 */
@WebServlet("/DayFourGetAllBookServlet")
public class DayFourGetAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String LOGIN_HREF = "day04/solved/login.html";
	public static final String LOGOUT_HREF = "DayFourLogoutServlet";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loggedInEmail = (String) session.getAttribute("loggedInEmail");
		PrintWriter out = response.getWriter();
		if (loggedInEmail == null) {
			response.sendRedirect(LOGIN_HREF);
		} else {
			out.println("<h1>Printing all books</h1>");
			out.println("<p>Logged In user: " + loggedInEmail + "</p>");
			out.println("<a href=" + LOGOUT_HREF + ">logout</a>");
		}
	}

}
