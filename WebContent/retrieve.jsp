<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- 
    Styling for table    
    https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro 
    -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retrieve Student Details</title>
</head>
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>

<body>

	<h1>Enter the Student Details</h1>

	<div>
		<form action="RetrieveDetailsServlet" method="GET"
			name="retrieve_form">
			First name: <input type="text" name="firstname" required><br>
			<br> Last name: <input type="text" name="lastname" required><br>
			<br> <input type="submit" value="Retrieve Details">
		</form>
	</div>

</body>
</html>