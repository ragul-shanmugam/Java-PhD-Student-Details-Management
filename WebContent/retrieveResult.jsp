<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ragul.db1.webinterface.StudentDetails"%>
<!-- 
    Styling for table    
    https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro 
    -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}

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
</head>
<body>

	<h1>Student Details for ${lname}, ${fname}</h1>

	<table>
		<tr>
			<th>Instructor FName</th>
			<th>Instructor LName</th>
			<th>Student Type</th>
			<th>Milestone Name</th>
			<th>Milestone Passed date</th>
		</tr>

		<%--  <%
 ArrayList<StudentDetails> studentlist = (ArrayList<StudentDetails>) request.getAttribute("studentdetails");
 int counter = 0;

 for(StudentDetails student : studentlist) {
	 
	 if(counter == 0)
	 {	 
	 out.print("Instructor First Name: " + student.getInsFirstName());
     out.print("<br/>");
     out.print("Instructor Last Name: " + student.getInsLastName());
     out.print("<br/>");
     out.print("Student Type: " + student.getStudentType());
     out.print("<br/>");
     out.print("Milestone Passed: " + student.getCname());
     out.print("<br/>");
     out.print("Milestone Passed Date: " + student.getPassdate());
     
     out.print("<br/>");
     out.print("<br/>");
	 }
	 else 
	 {
	     out.print("Milestone Passed: " + student.getCname());
	     out.print("<br/>");
	     out.print("Milestone Passed Date: " + student.getPassdate());
	     
	     out.print("<br/>");
	     out.print("<br/>");
	 }
	 
	counter += 1; 
 } %>
  --%>
		<%
			ArrayList<StudentDetails> studentlist = (ArrayList<StudentDetails>) request.getAttribute("studentdetails");

			int counter = 0;

			for (StudentDetails student : studentlist) {
				if (counter == 0) {
		%>
		<tr>
			<td><%=student.getInsFirstName()%></td>
			<td><%=student.getInsLastName()%></td>
			<td><%=student.getStudentType()%></td>
			<td><%=student.getCname()%></td>
			<td><%=student.getPassdate()%></td>
		</tr>

		<%
			} else {
		%>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td><%=student.getCname()%></td>
			<td><%=student.getPassdate()%></td>
		</tr>
		<%
			}

				counter += 1;
			}
		%>

	</table>

	<a href="retrieve.jsp"><input type="button"
		value="Retrieve Student Details" name="retrieve" /></a>
	<a href="insert.jsp"><input type="button"
		value="Insert Student Details" name="insert" /></a>

</body>
</html>