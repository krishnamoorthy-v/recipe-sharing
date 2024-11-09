<%@page import="com.saec.web.model.RecipeModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<style>
	img {
    width: 200px;
    height: 150px;
}
	
</style>
<body>
	
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="http://localhost:8085/myrecipe/index.jsp#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <form action="postRecipe" method="post">
				<input type="hidden" name="action" value="to create">
    			<input type="submit"  value="Go to Create">
		</form>
		<form action="getRecipe" class="container">
			<div>
				<input type="hidden" name="action" value="show">
				<input  type="submit" value="Show List">
			</div>
		</form>
		
      </div>
    </div>
  </div>
</nav>

	<% RecipeModel rm = (RecipeModel) request.getAttribute("recipe_info");
		String base64Image = "data:image/jpeg;base64, "+rm.getImage();
	%>

	<div >
	
		<div>
			<input type="hidden" name="id" value="<%=rm.getRid()  %>" >
		</div>
		
		<div class=text-center>
			<img src="<%= base64Image %>" class="rounded" alt="image" >
		</div>
		
		<div class="text-center">
		  <h1> <%= rm.getTitle() %></h1> 
		</div>
		
		<div class="text-center">
		  <%= rm.getDescription() %>
		</div>
			
	</div>
	
	
</body>
</html>