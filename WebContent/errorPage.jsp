<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<style>
input[type=button] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>
<body>

	<h1>${emptylist}</h1>

	<h1>${studentexists}</h1>

	<a href="retrieve.jsp"><input type="button"
		value="Retrieve Student Details" name="retrieve" /></a>
	<a href="insert.jsp"><input type="button"
		value="Insert Student Details" name="insert" /></a>

</body>
</html>