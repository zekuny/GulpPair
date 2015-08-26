<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>grades</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
.other-color {
	background: lightskyblue
}

.jumbotron h1 {
	color: slategray
}
</style>



<title>Welcome to Gulp!</title>
</head>
<body>
	<div class="container">

		<div class="container">
			<div class="jumbotron other-color">
				<center>
					<h1>Update Profile</h1>
				</center>
			</div>
		</div>

		<form class="form-horizontal" action="updateProfileServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-5" >User name: </label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_name"
						name="u_name">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-5">
					<center>
						<button type="submit" class="btn btn-primary btn-lg btn-block"
							value="addstudent">Update</button>
					</center>
				</div>
			</div>
		</form>
		
</div>	
</body>	
	
		
		