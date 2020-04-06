<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Update Book</title>
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
    <div align="center">
        <h1>Update Book</h1>
        <br />
        <form:form action="/success" method="POST" modelAttribute="book">
            <table border="0" cellpadding="10">
                <tr>
                     <td>Book Id:</td> 
                    <td><form:input path="id" readonly="readonly"  /></td>
                </tr> 
                <tr>
                    <td>Book Name:</td>
                    <td><form:input path="bookName" /></td>
                </tr>
    
                <tr>
                    <td colspan="2"><button type="submit">Update</button></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>

 