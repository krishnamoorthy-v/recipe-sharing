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


	
	<h1>Recipe</h1>
	<form onsubmit="checkStatus()" action="postRecipe" method="post" enctype="multipart/form-data" >
	
	
		
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">Title</label>
		  <input type="text" class="form-control" name="title" id="exampleFormControlInput1" placeholder="Title" required>
		</div>
		
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">Description</label>
		  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="description" required></textarea>
		</div>
		
		
		<div class="mb-3">
		  <label for="formFile" class="form-label">Recipe Image File</label>
		  <input class="form-control" type="file" accept="image/*" id="formFile" name="image" required>
		</div>
		
		
		<div>
			<input type="hidden" name="action" value="submit" > 
			<input class="btn btn-success" type="submit"/>
		</div>
		
	</form>
	
		<script type="text/javascript">
		function checkStatus() {
			<%
				System.out.println("check Status called");
				String status = (String)request.getAttribute("status"); 
				if (status != null) {
			%>
			
				confirm("<%= status %>");
			
			<%
				}
			%>
		}
		</script>
			
			
		
	
</body>
</html>