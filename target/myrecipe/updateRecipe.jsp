<%@page import="com.saec.web.model.RecipeModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipe</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>

<body>
	
	<%
		RecipeModel rm = (RecipeModel)request.getAttribute("recipe");
	%>

	
	<h1>Update Recipe</h1>
	<form action="UpdateServletController" method="post" onsubmit="checkStatus()" enctype="multipart/form-data">
		
		<div>
			<input type="hidden" name="id" value="<%=rm.getRid()  %>" >
		</div>
		
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">Title</label>
		  <input type="text" class="form-control" name="title" id="exampleFormControlInput1" value="<%= rm.getTitle() %>" required>
		</div>
		
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">Description</label>
		  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="description" required><%= rm.getDescription() %></textarea>
		</div>
		
		
		
		<div class="mb-3">
		  <label for="formFile" class="form-label">Recipe Image File</label>
		  <input class="form-control" type="file" accept="image/*" id="formFile" name="image">
		</div>
		
		
		<div>
			<input type="hidden" name="action" value="submit" > 
			<input class="btn btn-success" type="submit"/>
		</div>
		
	</form>
	
		<script type="text/javascript">
		function checkStatus() {
			<%
				String status = (String)request.getAttribute("status"); 
				if (status != null) {
			%>
			
				alert("<%= status %>");
			
			<%
				}
			%>
		}
		</script>
			
			
		
	
</body>
</html>