<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/skeleton.css">
  <link rel="stylesheet" href="css/custom.css">

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
        <h1>Book Search</h1>
        
		<div>
		<!-- REFER  jQuery autocomplete -->
			<label for="search">Keyword </label>
			<input id="search">
		</div>
		
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
				
				<tbody>
					<tr>
						<td>분노도 습관이다</td>
						<td>9788969520678</td>
						<td>Available: <a href="">Make a reservation</a></td>
						<td><a href="">Detail</a></td>
						
					</tr>
					
					<tr>
						<td>인문학은 밥이다</td>
						<td>9788925551562</td>
						<td>Not available yet: 2015-05-01 ~ 2015-05-31</td>
						<td><a href="">Detail</a></td>
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