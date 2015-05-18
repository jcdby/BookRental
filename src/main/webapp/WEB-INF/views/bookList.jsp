<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
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
  <link href="http://fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

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
  <link rel="icon" type="image/png" href="/images/favicon.png">

</head>
<body>




  <!-- Primary Page Layout
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <div class="container">
    <section class="row header">
      <div>
        <h1>Book Search</h1>
        
		<form action="<c:url value="/Book/Search"/>" method="get">
			<!-- <label for="query">Keyword </label> -->
			<input name="title" type="text" placeholder="Input Book title here">
			
			<input class="button" type="submit" value="Search">
		</form>
		
		
		<!-- Inflate search results here -->
		<div>
			<table class="u-full-width">
				<thead>
					<tr>
						<th>Name</th>
						<th>ISBN</th>
						<th>Status</th>
						<th>Link</th>
					</tr>
				</thead>
				
				<tbody id="books">				
				
				<script>
				
				$("#books");
				
				</script>
				
				
					<c:forEach items="${books}" var="book">
						<tr>
							<td><c:out value="${book.title}"></c:out></td>
							<td><c:out value="${book.noISBN}"></c:out></td>
							<td>Not implemented yet.</td>
							<td><a href="<c:url value="/Book/Detail/${book.identifier}"/>">Detail</a></td>
						</tr>
					</c:forEach>
					
					
				</tbody>
			</table>
		</div>
		
		
      </div>
    </section>
  </div>

<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
