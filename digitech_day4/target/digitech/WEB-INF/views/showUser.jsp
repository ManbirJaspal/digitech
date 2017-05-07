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
</head>
<body>  
<body>
<%-- <jsp:include page="header.jsp" /> --%>
<div class="container">
<c:forEach items="${list}" var="userdao">  
<table class="table">
<thead>
      <tr>
      
        <th>UserName</th>
        <th>Role</th>        
      </tr>
    </thead>
      <tr class="success">
        <td><c:out value="${userdao.username}"/></td>
        <td><c:out value="${userdao.role}"/></td>
        
      </tr>
    </tbody>
  </table>
</c:forEach>  
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<%-- <jsp:include page="footer.jsp" />     --%>
</body>  
</html>  