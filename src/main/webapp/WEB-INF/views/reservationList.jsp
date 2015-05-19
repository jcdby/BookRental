<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

<!-- JavaScript
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<!-- embed jQuery javascript file here -->


<!-- Favicon
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<link rel="icon" type="image/png" href="images/favicon.png">

</head>
<body>




	<!-- Primary Page Layout
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<div class="container">
		<section class="row header">
			<h1>Your Reservations</h1>
			<%@ include file="/WEB-INF/views/header.jsp"%>
		</section>

		<!-- Inflate reservations here -->
		<div class="docs-section">
			<table class="u-full-width">
				<thead>
					<tr>
						<th>Name</th>
						<th>ISBN</th>
						<th>Duration</th>
						<th>Link</th>
					</tr>
				</thead>

				<tbody id="books">

					<c:forEach items="${reservations}" var="reservation">
						<tr>
							<td><c:out value="${reservation.book.title}"></c:out></td>
							<td><c:out value="${reservation.book.noISBN}"></c:out></td>
							<td>
							<fmt:formatDate value="${reservation.from}" pattern="yyyy-MM-dd"/> ~						
							<fmt:formatDate value="${reservation.to}" pattern="yyyy-MM-dd"/></td>
							<td><a
								href="<c:url value="/Book/Detail/${reservation.book.identifier}"/>">Detail</a> / <a
								href="<c:url value="/Reservation/Cancel/${reservation.id}"/>">Cancel</a></td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
		</div>




	</div>

	<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
