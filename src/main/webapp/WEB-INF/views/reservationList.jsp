<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <link rel="stylesheet" href="<c:url value="/resources/css/normalize.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/skeleton.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/custom.css"/>">
  
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
      <div>
        <h1>Your Reservations</h1>
		
		<!-- Inflate reservations here -->
		<div>
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
				
				<script>
				
				$("#books");
				
				</script>
				
					<tr>
						<td>분노도 습관이다</td>
						<td>9788969520678</td>
						<td>2015-05-01 ~ 2015-05-31</td>
						<td><a href="">Detail</a> <a href="">Cancel</a></td>
						
					</tr>
					
					<tr>
						<td>인문학은 밥이다</td>
						<td>9788925551562</td>
						<td>2015-05-01 ~ 2015-05-31</td>
						<td><a href="">Detail</a> <a href="">Cancel</a></td>
					</tr>
					
					
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
