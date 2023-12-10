<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Welcome to Book Web App</h1>

	<%!public static final String LOGOUT_SERVLET = "DayFiveSolvedLogoutServlet";%>
	<%!public static final String LOGIN_HREF = "day05/solved/login.jsp";%>

	<%
	String loggedInEmail = (String) session.getAttribute("loggedInEmail");

	if (loggedInEmail == null) {
		response.sendRedirect(LOGIN_HREF);
	}
	%>

	<p>
		Logged In user:
		<%=loggedInEmail%>
	</p>
	<a href=<%=LOGOUT_SERVLET%>>logout</a>
</body>
</html>