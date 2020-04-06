<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Delete Book</title>
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
input[type=submit]{
width:10%;
background-color: #DC143C;
color:white
padding:10px 15px;
margin:90px 0;
}
</style>
</head>
<body>
	
	<div align="center">
   <h1>Delete Book</h1><br><br>
    <form action="/deletebooks" >
        Book Id:&nbsp;
       <br><br> <select name="id">
            <c:forEach items="${booklist}" var="books">
                <option value="${books.id}">                   
                    
                    ${books.id}
                </option>
            </c:forEach>
        </select>
        <br/><br/>
        <input type="submit" value="Delete" />
    </form>
</div>
</body>
</html>

