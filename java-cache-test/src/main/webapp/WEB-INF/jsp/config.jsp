<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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

	<h3>Cache Config</h3>

	<form method="post" action="setup">
		<div class="row">
			<div class="col-25">
				<label for="fname">Level</label>
			</div>
			<div class="col-75">
				<select name="level" id="level">
					<option value="memory">memory</option>
					<option value="file">file</option>
				</select> 
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="fname">Strategy</label>
			</div>
			<div class="col-75">
				<select name="strategy" id="strategy">
					<option value="LRU">LRU</option>
					<option value="LFU">LFU</option>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="fname">Max Size</label>
			</div>
			<div class="col-75">
				<input type="text" name="maxsize">
			</div>
		</div>
		<div class="row">
			<input type="submit" value="Submit">
		</div>
	</form>



</body>
</html>