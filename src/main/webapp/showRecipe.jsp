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
	<style>
		#container {
		width: 500px;
		display: flex;
		flex-direction: row;
		justify-content: space-evenly;
		flex-wrap:wrap;
		margin: 20px;
		
		}
	
		* {
			  box-sizing: border-box;
			}
			
		body {
		  font-family: Arial, Helvetica, sans-serif;
		}
		
		
		.column {
		  float: left;
		  width: 25%;
		  padding: 0 10px;
		}
		
		/* Remove extra left and right margins, due to padding */
		.row {margin: 0 -5px;}
		
		/* Clear floats after the columns */
		.row:after {
		  content: "";
		  display: table;
		  clear: both;
		}
		
		/* Responsive columns */
		@media screen and (max-width: 600px) {
		  .column {
		    width: 100%;
		    display: block;
		    margin-bottom: 20px;
		  }
		}
		
		/* Style the counter cards */
		.card {
		  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
		  padding: 16px;
		  text-align: center;
		  background-color: #f1f1f1;
		  margin-top: 10px;
		}
		
	</style>
	<script>
		function copytoClipboard(id) {
		//	let copy = document.getElementById("share_link");
			let url = "http://localhost:8085/myrecipe/getRecipe?action=getOneRecipe&rid="+id;
			navigator.clipboard.writeText(url).then( ()=> {
				alert("Link copied to clipboard!");
			})
		
			
		}
		
	</script>
	
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


	<div class="row">
	
	<%
		List<RecipeModel> recipes = (List<RecipeModel>) request.getAttribute("recipe_info");
	 for(RecipeModel rm: recipes) { 
		 String base64Image = "data:image/jpeg;base64, "+rm.getImage();
		 String description = rm.getDescription();
		 if(description.length() > 100) {
			 description = description.substring(0, 100)+"...";
		 }
	%>	
	<div class="column" style="width: 18rem;">
	  
	  <div class="card">
	  <img src="<%= base64Image %>" class="card-img-top" alt="image">
	    <h5 class="card-title"><%= rm.getTitle() %></h5>
	    <p class="card-text"><%= description %></p>
	    <div style="display: flex; flex-direction: row;">
	    	<form action="getOneRecipe" method="get">
				<input type="hidden" name="id" value="<%= rm.getRid() %>">
				<button type="submit" class="btn btn-primary">Update</button>
			</form>
		
			 <form action="DeleteRecipe" method="post">
	         	<input type="hidden" name="id" value="<%= rm.getRid() %>">
	            <button type="submit" class="btn btn-danger">Delete</button>
	         </form>
	         
	         <div>
				<button class="btn btn-secondary" onclick="copytoClipboard(<%=rm.getRid()%>)">Share</button>
			</div>
	    
	    </div>
		
	  </div>
	</div>
	
	
   <% } %>
	
	</div>
</body>
</html>