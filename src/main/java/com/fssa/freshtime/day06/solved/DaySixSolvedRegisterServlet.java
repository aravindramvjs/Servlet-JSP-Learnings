package com.fssa.freshtime.day06.solved;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DaySixSolvedRegisterServlet
 */
@WebServlet("/DaySixSolvedRegisterServlet")
public class DaySixSolvedRegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static String REGISTER_JSP = "day06/solved/register.jsp?";
	private static String LOGIN_JSP = "day06/solved/login.jsp";
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		if(email == null || "".equals(email)) {
			System.out.println("Invalid Email");
			response.sendRedirect(REGISTER_JSP + "errorMessage=Invalid Name");
		}
		else if(name == null || "".equals(name)) {
			System.out.println("Invalid Name");
			response.sendRedirect(REGISTER_JSP + "errorMessage=Invalid Email");
		}
		else if(password == null || "".equals(password) || password.length() < 6) {
			response.sendRedirect(REGISTER_JSP + "errorMessage=Invalid Password" );	
		}
		else {
			System.out.println("User registered Successfully");
			RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN_JSP);
			dispatcher.forward(request, response);
		}
		
	}

}
