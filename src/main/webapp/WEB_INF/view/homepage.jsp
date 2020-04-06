<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Spring Boot</title>


<style type="text/css">

h1{
font-family: consolas;
border:2px solid #73AD21;
border-radius: 25px;
margin:0;
padding: 10px 0;
}
 body {
      background-color: powderblue;
      
        margin:auto;
        width: 50%;
        border: 3px solid #897878;
        padding :10px;
  }
    button {
    cursor: pointer;
    
    background-color: #DC143C; 
  border: none;
  color: white;
  padding: 2px 8px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  }
  .error{
  color:red;
  font:italic;
  }
</style>


</head>
<body>



	<%@page import="java.util.ArrayList"%>
	<%@page import="com.mindtree.kalingalibrary.entity.Library"%>
	<%@page import="java.util.Iterator"%>
	<%
		ArrayList<Library> listLibrary = (ArrayList) request.getAttribute("listLibrary");
	%>



	<div align="center">
		<h1>Library Management</h1>



		<br /> <br />
		<table border="1" cellpadding="10">
			<thead>
				<tr>
					<th>Library ID</th>
					<th>Library Name</th>
					<th>Actions</th>

				</tr>
			</thead>


			<tbody>

				<%
					Iterator<Library> iterator = listLibrary.iterator();

					while (iterator.hasNext()) {
						Library library = iterator.next();
				%>
				<tr>
					<td><%=library.getId()%></td>
					<td><%=library.getLibraryName()%></td>



					<td><a href="/update/<%=library.getId()%>  ">Update</a>
						&nbsp;&nbsp;&nbsp; <a href="/details/<%=library.getId()%>">Details</a>

					</td>

				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<br>


		<h1>
			<a href="/add">
				<button name="button" type="button">Add</button>
			</a>
		</h1><br><br>
		<h1>
			<a href="/deletelibrary">
				<button name="button" type="button">Delete</button>
			</a>
		</h1>

	</div>
</body>
</html>

