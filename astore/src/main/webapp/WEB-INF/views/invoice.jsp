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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Invoice</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div class="container"> 
 Order Details           
  <table class="table">
    <thead>
    <c:forEach items="${carts}" var="cat">
      <tr>
        <th>Product Name</th>
         <td>${cat.cartProductName}</td>   
      </tr>
      </c:forEach>
    </thead>
    <tbody>
    <c:forEach items="${carts}" var="cat">
    <tr>
      <th>Price</th>
      <td>${cat.cartprice}</td>
    </tr>
      </c:forEach>
    <tr>
         <th>User Address</th>
         <td>${userdetails.address}</td>
    </tr>
    <tr>
        <th>Total Cost</th>
        <td>${orderdetails.total}</td>
    </tr>
              
    </tbody>
  </table> 
  <a href="ack" class="btn btn-info" role="button">OK</a> 
</div>
</body>
</html>