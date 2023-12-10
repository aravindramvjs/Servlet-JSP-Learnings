package com.fssa.freshtime.day06.solved;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/DaySixSolvedLoginServlet")
public class DaySixSolvedLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String LOGIN_JSP = "day06/solved/login.jsp";
	private static String HOME_JSP = "day06/solved/home.jsp";
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email == null || "".equals(email)) {
			System.out.println("Invalid Email");
			response.sendRedirect(LOGIN_JSP + "?errorMessage=Invalid Email");
		}
		
		else if(password == null || "".equals(password) || password.length() < 6) {
			response.sendRedirect(LOGIN_JSP + "?errorMessage=Invalid Password");	
		}
		else {
			System.out.println("Email and password is valid");
			HttpSession session = request.getSession();
			session.setAttribute("loggedInEmail", email);
//			request.setAttribute("loggedInEmail", email); // Only the next page or servlet can access the request scope attribute values. 
			RequestDispatcher dispatcher = request.getRequestDispatcher(HOME_JSP);
			dispatcher.forward(request, response);
		}
		
	}

}