<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<section class="header">
			<!-- Set action url to modification if Book attribute exists in the 'model'. -->
			<h1>Book Registration Form</h1>
			<%@ include file="/WEB-INF/views/header.jsp"%>
		</section>

		<div class="docs-section u-full-width" style="text-align:center;">
			<form method="post" action="<c:url value="/Book/Register"/>">
				<div>
					<!-- <label class="field-label">Title</label> -->
					<input id="title" class="u-full-width" name="title" type="text"
						required="required" placeholder="Title here">
				</div>

				<div>
					<!-- <label class="field-label">ISBN</label> -->
					<input id="isbn" class="u-full-width" name="isbn" type="text"
						required="required" placeholder="ISBN here">
				</div>

				<textarea rows="7" class="u-full-width"
					placeholder="Description here" id="description" name="description"></textarea>

				<input class="button" type="submit" value="Register">
					
			</form>

		</div>

	</div>

	<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
