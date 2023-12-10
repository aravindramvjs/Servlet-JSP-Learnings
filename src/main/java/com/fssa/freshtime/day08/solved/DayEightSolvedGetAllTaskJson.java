package com.fssa.freshtime.day08.solved;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.fssa.freshtime.exceptions.ServiceException;
import com.fssa.freshtime.models.Task;
import com.fssa.freshtime.services.TaskService;

/**
 * Servlet implementation class GetAllAccounts
 */
@WebServlet("/GetAllAccountJSONServlet")
public class DayEightSolvedGetAllTaskJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TaskService service = new TaskService();

		try {
			List<Task> tasklist = service.readAllTask();
			JSONArray tasksJSonArray = new JSONArray(tasklist);
			
			PrintWriter out = response.getWriter();
			
			out.println(tasksJSonArray.toString());
			
			out.flush();
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}


	}

}