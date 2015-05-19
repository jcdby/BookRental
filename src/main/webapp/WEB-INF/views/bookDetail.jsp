<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<meta charset="utf-8">
<title>Your page title here :)</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Mobile Specific Metas
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<link href="http://fonts.googleapis.com/css?family=Raleway:400,300,600"
	rel="stylesheet" type="text/css">

<!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<link rel="stylesheet" href="<c:url value="/css/normalize.css"/>">
<link rel="stylesheet" href="<c:url value="/css/skeleton.css"/>">
<link rel="stylesheet" href="<c:url value="/css/custom.css"/>">

<!-- Favicon
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<link rel="icon" type="image/png" href="/images/favicon.png">

</head>
<body>

	<!-- Primary Page Layout
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<div class="container">
		<section class="row header">
			<h1>Book Detail</h1>
			<%@ include file="/WEB-INF/views/header.jsp"%>

		</section>
		<div class="docs-section u-full-width">
			<h1>${requestedBook.title}</h1>

			<div>
				<p>${requestedBook.description}</p>
			</div>

			<h4>Current Reservations</h4>
			<ul>
				<c:forEach items="${reservations}" var="reservation">
					<li><c:out value="${reservation.user.name}"></c:out>, <fmt:formatDate
							value="${reservation.from}" pattern="yyyy-MM-dd" /> ~ <fmt:formatDate
							value="${reservation.to}" pattern="yyyy-MM-dd" /></li>
				</c:forEach>
			</ul>
			
			<form method="post"
				action="<c:url value="/Book/Reserve/${requestedBook.identifier}"/>">
				<div class="row">
					<div class="six columns">
						<label for="date-from">From</label> <input class="u-full-width"
							type="date" name="date-from" placeholder="0000-00-00">
					</div>
					<div class="six columns">
						<label for="date-to">To</label> <input class="u-full-width"
							type="date" name="date-to" placeholder="0000-00-00">
					</div>
				</div>
				<div style="text-align: center">
					<input class="button" type="submit" value="Make a reservation">
					<a class="button" href="javascript:history.go(-1)">Back to the
						book list</a>
				</div>
			</form>


			<!--
			<h4>Book is not available yet. </h4>
			<h5>2015-05-13 ~ 2015-05-27</h5>
			-->

			<!-- Inflate search results here -->


		</div>


	</div>

	<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
