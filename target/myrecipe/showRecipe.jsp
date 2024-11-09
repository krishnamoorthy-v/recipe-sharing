<%@page import="com.saec.web.model.RecipeModel"%>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>

<body bgcolor="cyan">
	
	<%
		List<RecipeModel> recipes = (List<RecipeModel>) request.getAttribute("recipe_info");
	 for(RecipeModel rm: recipes) { 
		 String base64Image = "data:image/jpeg;base64, "+rm.getImage();
	%>	
	<div class="card" style="width: 18rem;">
	  <img src="<%= base64Image %>" class="card-img-top" alt="...">
	  <div class="card-body">
	    <h5 class="card-title"><%= rm.getTitle() %></h5>
	    <p class="card-text"><%= rm.getDescription() %></p>
	    <form action="getOneRecipe" method="get">
			<input type="hidden" name="id" value="<%= rm.getRid() %>">
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	  </div>
	</div>
	
   <% } %>
	
	
</body>
</html>