<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar">
	<div class="container">
		<ul class="navbar-list">
			<li class="navbar-item"><a class="navbar-link"
				href="<c:url value="/"/>">Home</a></li>

			<%
				//Get login status from session attribute
				Boolean isLoggedIn = (Boolean) session.getAttribute("logininfo");
				String userid = (String) session.getAttribute("userid");

				if (isLoggedIn != null) {
			%>
			<li class="navbar-item"><a class="navbar-link"
				href="<c:url value="/User/Modify"/>"><%= userid %></a></li>
			<li class="navbar-item"><a class="navbar-link"
				href="<c:url value="/User/Logout"/>">Logout</a></li>
			<%
				} else {
			%>
			<li class="navbar-item"><a class="navbar-link"
				href="<c:url value="/User/Login"/>">Login</a></li>

			<%
				}
			%>

		</ul>
	</div>
</nav>

