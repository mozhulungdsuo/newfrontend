<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Cart</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div class="container">            
  <table class="table">
    <thead>
      <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Action</th>        
      </tr>
    </thead>
    <tbody>
      
     <c:forEach items="${carts}" var="cat">
     <tr>
        <td>${cat.cartProductID}</td>
        <td>${cat.cartProductName}</td>       
        <td><a href="deletePCart?pid=${cat.cartProductID}">Delete</a></td>
          </tr>
           </c:forEach> 
    </tbody>
  </table>  
  <a href="${pageContext.request.contextPath}/" class="btn btn-info" role="button">Continue Shopping</a>
 <a href="${pageContext.request.contextPath}/checkOut" class="btn btn-info" role="button">Check Out</a>

</div>

</body>
</html>