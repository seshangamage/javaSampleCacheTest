<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Cache</title>
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
	<div align="center">
		<h3>Cache Data </h3>
		<br>
		<h4>${cache.viewCache()}</h4>
		<br>
		<a href="/add" class="btn default" role="button">Add Student</a>

	</div>
</body>
</html>