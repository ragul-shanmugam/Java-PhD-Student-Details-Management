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
<title>Insert Student Details</title>
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

input[type=reset] {
	width: 100%;
	background-color: #45a049;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<body>

	<h1>Enter the Student Details</h1>

	<h3>${studentexists}</h3>

	<form action="InsertDetailsServlet" method="GET" name="insert_form">
		Enter Student ID: <input type="text" name="sid" required><br>
		<br> Enter Student First name: <input type="text"
			name="firstname" required><br> <br> Enter Student
		Last name: <input type="text" name="lastname" required><br>
		<br> Select Student Type: <select name="stype"
			onchange="java_script_:show(this.options[this.selectedIndex].value)"
			required>
			<option value="select">Select One</option>
			<option value="gra">GRA</option>
			<option value="gta">GTA</option>
			<option value="scholarship">Scholarship Support</option>
			<option value="self">Self Support</option>
		</select><br> <br>

		<div id="grafunding" style="display: none">
			Select Funding Type: <select name="ftype" required>
				<option value="select">Select One</option>
				<option value="doe1">DOE1</option>
				<option value="nsf2">NSF2</option>
				<option value="nih3">NIH3</option>
				<option value="dot4">DOT4</option>
			</select><br> <br>
		</div>
		<div id="gtasection" style="display: none">
			Select the Section: <select name="sectype" required>
				<option value="select">Select One</option>
				<option value="CSE1310">CSE1310</option>
				<option value="CSE1320">CSE1320</option>
				<option value="CSE1325">CSE1325</option>
				<option value="CSE3302">CSE3302</option>
				<option value="CSE3310">CSE3310</option>
				<option value="CSE3330">CSE3330</option>
				<option value="CSE3442">CSE3442</option>
				<option value="CSE4351">CSE4351</option>
				<option value="CSE4354">CSE4354</option>
				<option value="CSE5322">CSE5322</option>
				<option value="CSE5324">CSE5324</option>
				<option value="CSE6338">CSE6338</option>
				<option value="CSE6365">CSE6365</option>
			</select><br> <br>
		</div>
		<div id="scholartype" style="display: none">
			Select Scholarship Type: <select name="schtype" required>
				<option value="select">Select One</option>
				<option value="STEM">STEM</option>
				<option value="Maverick">Maverick</option>
				<option value="Departmental">Departmental</option>
			</select><br> <br>
		</div>
		<br> Enter Student Start Semester: <input type="text"
			name="stsem" required><br> <br> Enter Student Start
		Year: <input type="text" name="styear" required><br> <br>
		Enter Supervisor ID: <input type="text" name="iid" required><br>
		<br> Enter Supervisor First name: <input type="text"
			name="ifirstname" required><br> <br> Enter
		Supervisor Last name: <input type="text" name="ilastname" required><br>
		<br> Select Supervisor Type: <select name="itype" required>
			<option value="select">Select One</option>
			<option value="Adjunct">Adjunct</option>
			<option value="TT">TT</option>
		</select><br> <br> <input type="submit" value="Insert Details">
		<input type="reset" value="Clear" onClick="window.location.reload()">
	</form>

	<script type="text/javascript">
		function show(value) {
			if (value == "gra") {
				grafunding.style.display = 'inline-block';
				gtasection.style.display = 'none';
				scholartype.style.display = 'none';
				Form.fileURL.focus();
			} else if (value == "gta") {
				gtasection.style.display = 'inline-block';
				grafunding.style.display = 'none';
				scholartype.style.display = 'none';
				Form.fileURL.focus();
			} else if (value == "scholarship") {
				scholartype.style.display = 'inline-block';
				grafunding.style.display = 'none';
				gtasection.style.display = 'none';
				Form.fileURL.focus();
			} else {
				grafunding.style.display = 'none';
				gtasection.style.display = 'none';
			}
		}
	</script>
</body>
</html>