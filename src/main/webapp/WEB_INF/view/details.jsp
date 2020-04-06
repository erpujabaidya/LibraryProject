<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>



<title>Spring Boot</title>



<style  type="text/css">
body {
      background-color: powderblue;
      
        margin:auto;
        width: 50%;
        border: 3px solid #897878;
        padding :10px;
  }
  h1{
font-family: consolas;
border:2px solid #73AD21;
border-radius: 25px;
margin:0;
padding: 10px 0;
}

div{
border-radius: 5px;
background-color:#FFFFE0;
padding:20px; 
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
</style>
</head>
<body>



	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
	<%@page import="com.mindtree.kalingalibrary.entity.Book"%>
	<%@page import="com.mindtree.kalingalibrary.entity.Library"%>
	<%@page import="java.util.Iterator"%>
	<%
	Library library=(Library)request.getAttribute("library");
	
		List<Book> listBooks = library.getBooks();
		
		
	%>



	<div align="center">
		<h1>Library Details</h1>



		<br />
		<br />
		<table border="1" cellpadding="10">
			<thead>
				<tr>
					<th>Book ID</th>
					<th>Book Name</th>


				</tr>
			</thead>


			<tbody>

				<%
					Iterator<Book> iterator = listBooks.iterator();

					while (iterator.hasNext()) {
						Book book = iterator.next();
				%>
				<tr>
					<td><%=book.getId()%></td>
					<td><%=book.getBookName()%></td>




				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<br> 
		<h1><a href="/addbook/<%=library. getId()%>"><button name="button" type="button">Add</button></a>&nbsp;&nbsp;&nbsp;</h1>
		<br>
			<h1> <a href="/updatebook/<%=library. getId()%>">
			<button name="button" type="button">Update</button></h1><br>
		</a>  <a href="/deletebook/<%=library. getId()%>">
			<h1><button name="button" type="button">Delete</button> 
		</a></h1>

	</div>
</body>
</html>

