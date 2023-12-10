<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking</title>
</head>
<body>

	<%!public static final String LOGOUT_SERVLET = "../../DayFourPracticeLogoutServlet";%>

	<h1>
		Welcome,
		<%=session.getAttribute("loggedInUser")%></h1>
	<!-- Your booking form and content here -->
	<%
	int sessionTimeout = session.getMaxInactiveInterval(); // Get session timeout in seconds
	%>

	<div>
		<p>
			Your session will expire in
			<%=sessionTimeout%>
			seconds.
		</p>
		<p>Please make sure to save your work before the session expires.</p>
	</div>

	<!-- Redirect to LogoutServlet when the session expires -->
	<%
	String redirectUrl = response.encodeRedirectURL(LOGOUT_SERVLET);
	response.setHeader("Refresh", sessionTimeout + "; URL=" + redirectUrl);
	%>
</body>
</html>
