<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.fssa.freshtime.models.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Tasks</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
	<h1>Task List</h1>
	<table>
		<thead>
			<tr>
				<td>CheckBox</td>
				<td>Task Name</td>
				<td>Description</td>
				<td>Due Date</td>
				<td>Priority</td>
				<td>Status</td>
				<td>Notes</td>
				<td>Reminder</td>	
			</tr>	
		</thead>
		<tbody>
	
		<c:forEach var="task" items="${listTask}" varStatus="loop">
			<tr>
				<td><input type="checkbox"></td>
				<td><c:out value = "${task.getTaskName()}" /></td>
				<td><c:out value = "${task.getDescription()}" /></td>
				<td><c:out value = "${task.getDueDate()}" /></td>
				<td><c:out value = "${task.getPriority()}" /></td>
				<td><c:out value = "${task.getStatus()}" /></td>
				<td><c:out value = "${task.getNotes()}" /></td>
				<td><c:out value = "${task.getReminder()}" /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</body>
</html>