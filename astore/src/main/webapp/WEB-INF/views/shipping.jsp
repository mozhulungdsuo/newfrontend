<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipping</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">
<form action="orderProcess" method="post">
<table class="table">
    <tr>
    <th>Name</th>
    <td>${user.name}</td>
    </tr>
      <tr>
        <th>E-mail</th>
        <td>${user.email}</td>
       </tr>    
   
      <tr>
        <th>Address</th>
        <td>${user.address}</td>
       
      </tr>
       <tr>
       <th>Phone no</th>
       <td>${user.phone}</td>
      </tr>
      <tr>
      <th>Total</th>
      <td>
      <c:set var="total" value="${0}" />
     
      <c:forEach var="cat" items="${carts}">
       <c:set var="total" value="${total + cat.cartprice}" />
      </c:forEach>
       ${total}  <input type="hidden" id="total" name="total" value="${total}"/>
      </td>    
      </tr>
     
  </table>
    
      <input type="radio" name="payment" value="COD">COD</input>
   
      <input type="radio" name="payment" value="Debit Card">Debit Card</input>
   
  
      <input type="radio" name="payment" value="Net Banking">Net Banking</input>
   
 

<button type="submit" action="orderProcess">Place Order</button>
</form>
</div>
</body>
</html>