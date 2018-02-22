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
<title>Details</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">
<form action="addToCart" method="get">
<table class="table">
<tr>
<th> Product Image</th>
<td><img src="${contextRoot}${item.imgname}" width="100" height="100" alt="No imag available"></td>
</tr>
    <tr>
    <th>Product ID</th>
    <td ><input type="text" id="pid" placeholder="units"  name="pid" value="${item.pid}" readonly="readonly"/></td>
    </tr>
      <tr>
        <th>Product name</th>
        <td ><input type="text" id="pname" placeholder="units" name="pname" value="${item.pname}" readonly="readonly"/></td>
       </tr>    
   
      <tr>
        <th>Supplier ID</th>
        <td ><input type="text" id="supplierName"  name="supplierName" placeholder="units" value="${sup.supplierName}" readonly="readonly"/></c></td>
       
      </tr>
       <tr>
       <th>Price</th>
       <td ><input type="text" id="price" name="price" placeholder="units" value="${item.price}" readonly="readonly"/></td>
      </tr>
      <tr>
      <th>Description</th>
      <td><c>${item.description}</c></td>
      </tr>
     
      <tr>
        <th>Quantity</th>
        <td><input type="text" id="quantity" name ="quantity" placeholder="Enter quantity here"/></td>
       </tr>
     
  
  </table>
  <input type="hidden" name="imgname" value="${item.imgname}"/>
<button type="submit" action="addToCart">Add to cart</button>
</form>
</div>
</body>
</html>