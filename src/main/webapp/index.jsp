<html>
<head>
	<title>
		Recipe
	</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	
</head>

<style>
	#container {
		
		width: 500px;
		padding: 10px;
		
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
	
	
	
	<form action="getRecipe" class="container">
		
		<div class="mb-3">
		  <label for="formGroupExampleInput" class="form-label">Recipe Id</label>
		  <input type="hidden" name="action" value="getOneRecipe" >
		  <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Enter the Id" name="rid">
		</div>
		
		
		<div>
			<input class="btn btn-success" type="submit">
		</div>
	
	</form>
</body>
</html>
