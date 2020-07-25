<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.btn {
	border: 2px solid black;
	background-color: white;
	color: black;
	padding: 14px 28px;
	font-size: 16px;
	cursor: pointer;
}

/* Gray */
.default {
	border-color: #e7e7e7;
	color: black;
}

.default:hover {
	background: #e7e7e7;
}
</style>
</head>
<body>

	<h1>Cache Config</h1>

	<form method="post" action="setup">
		Level : <select name="level" id="level">
					<option value="memory">memory</option>
					<option value="file">file</option>
				</select> <br>
		Strategy : <select name="strategy" id="strategy">
					<option value="LRU">LRU</option>
					<option value="LFU">LFU</option>
				</select> <br>
		Max Size : <input type="text" name="maxsize"><br> 
		<input type="submit" value="Submit">
	</form>



</body>
</html>