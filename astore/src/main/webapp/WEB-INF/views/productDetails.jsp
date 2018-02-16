<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Details</title>
</head>
<body>

<table class="table">
    
      <tr>
        <th>Product name</th>
        <td><c>${item.pname}</c></td>
       </tr>    
   
      <tr>
        <th>Supplier</th>
        <td><c>${sup.supplierName}</c></td>
       
      </tr>
      <tr>
      <th>Description</th>
      <td><c>${item.description}</c></td>
      </tr>
      <tr>
        <th>Quantity</th>
        <td><input type="text" id="" placeholder="units"/></td>
       </tr>
     
  
  </table>
<button type="submit">Add to cart</button>


</body>
</html>