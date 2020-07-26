<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>

<style>
input[type=text], select {
  width: 20%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

input[type=text] {
	width: 20%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}

input[type=submit]:hover {
	background-color: #696969;
}

input[type=submit] {
  background-color: #A9A9A9;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: left;
}

.col-25 {
	float: left;
	width: 10%;
	margin-top: 6px;
}

.col-75 {
	float: left;
	width: 90%;
	margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>
</head>
<body>
	<h3>Add Student data to cache</h3>

	<form method="post" action="/add">
		<div class="row">
			<div class="col-25">
				<label for="fname">ID</label>
			</div>
			<div class="col-75">
				<input type="text" name="id">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="fname">Name</label>
			</div>
			<div class="col-75">
				<input type="text" name="name">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="fname">Age</label>
			</div>
			<div class="col-75">
				<input type="text" name="age">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="fname">Address</label>
			</div>
			<div class="col-75">
				<input type="text" name="address">
			</div>
		</div>
		<div class="row">
			<input type="submit" value="Submit">
		</div>
	</form>
</body>
</html>