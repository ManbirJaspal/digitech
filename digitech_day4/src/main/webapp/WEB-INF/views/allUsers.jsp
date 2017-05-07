<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
</head>
<body>  
<body>



<div class="container">
<c:forEach items="${list}" var="userdao">  
<table class="table">
<thead>
      <tr>
        <th>username</th>      
        <th>email</th> 
        <th>address</th>
      <th>mobile</th>
      </tr>
    </thead>
      <tr class="success">
        <td><c:out value="${userdao.username}"/></td>
               <td><c:out value="${userdao.emailid}"/></td>
               <td><c:out value="${userdao.address}"/></td>
               <td><c:out value="${userdao.mobile}"/></td>
      </tr>
    </tbody>
  </table>
</c:forEach>  
</div>