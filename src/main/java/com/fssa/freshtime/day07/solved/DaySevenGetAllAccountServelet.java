package com.fssa.freshtime.day07.solved;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.freshtime.exceptions.ServiceException;
import com.fssa.freshtime.models.*;
import com.fssa.freshtime.services.TaskService;

/**
 * Servlet implementation class DaySevenGetAllAccountServelet
 */
@WebServlet("/DaySevenGetAllAccountServelet")
public class DaySevenGetAllAccountServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TaskService service = new TaskService();
	private static final String VIEW_TASKS_PAGE = "day07/solved/viewTask.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
		
			List<Task> listTask = service.readAllTask();
			request.setAttribute("listTask", listTask);


			RequestDispatcher rd = request.getServletContext().getRequestDispatcher(VIEW_TASKS_PAGE);
			rd.forward(request, response);
			

		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
