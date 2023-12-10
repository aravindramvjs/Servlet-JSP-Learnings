<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.fssa.freshtime.day05.practice.User"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users Page</title>
</head>
<body>

	<h3>List Users</h3>

	<%
	List<User> usersList = (List<User>) request.getAttribute("usersList");

	if (usersList != null && !usersList.isEmpty()) {
	%>
	<table border="1">

		<thead>
			<tr>
				<th>Userid</th>
				<th>Name</th>
				<th>EmailId</th>
			</tr>
		<thead>
		</tbody>
		<%
		for (User user : usersList) {
		%>

		<tr>

			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getEmailId()%></td>

		</tr>

		<%
		}
		%>

		</tbody>

	</table>

	<%
	}
	%>


</body>
</html>