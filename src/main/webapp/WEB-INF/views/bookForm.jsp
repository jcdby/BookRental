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

<!-- JavaScript
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<!-- jQuery -->
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>

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

		<div class="docs-section u-full-width" style="text-align: center;">
			<form method="post" action="<c:url value="/Book/Register"/>">
				<div>
					<!-- <label class="field-label">Title</label> -->
					<input id="title" class="u-full-width" name="title" type="text"
						required="required" placeholder="Title here" size="4">
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
			<div id="google-book-search" style="display: none">
					<div id="google-book-search-info"></div>
					<div id="google-book-search-result"></div>
			</div>
		</div>

	</div>
	<script>
	$("#title").keydown(function(e) {
		  if(e.keyCode == 13 || e.keyCode == 9) {
		    $("#isbn").trigger("click");
		  }
		});
	$("#isbn").bind("click", function(){
		//if($("#google-book-search-info").is(":visible")) {
			if($('#title').val()!="") {
				$('#google-book-search-info').html("<p><em>Are you looking for these books?</em></p>");
				$("#google-book-search").show();
				$.ajax({
	                url: "https://www.googleapis.com/books/v1/volumes?q=" + $('#title').val(),
	                dataType: "json",
	                success: function (data) {
	                	$('#google-book-search-result').empty();               	
	                    	var maxResults = 5;
	                    	if(data['totlaItems'] < 5){
		                		maxResults = data['totlaItems'];
		                	}
	                    	for(var i = 0; i < maxResults; ++i) {
	                    		var smallThumbnail = "https://books.google.co.kr/googlebooks/images/no_cover_thumb.gif",
	                    			title = data['items'][i]['volumeInfo']['title'],
	                    			isbn = "",
	                    			description = "";
	                    		
								if(typeof data['items'][i]['volumeInfo']['imageLinks'] != "undefined") {
									smallThumbnail = data['items'][i]['volumeInfo']['imageLinks']['smallThumbnail'];
								}
								if(typeof data['items'][i]['volumeInfo']['industryIdentifiers'] != "undefined" ) {
									isbn = data['items'][i]['volumeInfo']['industryIdentifiers'][0]['identifier'];
								}
								if(typeof data['items'][i]['volumeInfo']['description'] != "undefined") {
									description = data['items'][i]['volumeInfo']['description'];
								}

	                        	$("#google-book-search-result").append(
	                        			"<a href = 'javascript:insertBook(" + i + ");'><div id='searchSmallThumbnail" + i 
	                        			+ "'><img src='" + smallThumbnail + "'/></div></a><div id='searchTitle" + i 
	                        			+ "'>" + title + "</div><div id='searchIsbn" + i 
	                        			+ "'>" + isbn + "</div><div id='searchDescription" + i 
	                        			+ "'>" + description + "</div>"
	                        	)};
	                },
	                error: function () {
	                    console.log("error");
	                }
	            });
			} else {
				$("#google-book-search").hide();
			}
		
	});
	function insertBook(i) {
		$("#title").val($('#searchTitle' + i).text());
		$("#isbn").val($('#searchIsbn' + i).text());
		$("#description").val($('#searchDescription' + i).text());
	}
	</script>

	<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
