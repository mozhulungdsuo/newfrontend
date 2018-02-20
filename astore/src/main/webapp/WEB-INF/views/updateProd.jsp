<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Edit Product</title>
</head>
<body>

     <%@include file="/WEB-INF/views/header.jsp"%>
     <div class="container">
      <form method="post" action="saveProd1" enctype="multipart/form-data">
    <div class="form-group">
      <label for="pid">Product ID:</label>
      <input type="text" class="form-control" id="pid"  name="pid" value="${item.pid}">
    </div>
    <div class="form-group">
      <label for="pname">Product Name:</label>
      <input type="text" class="form-control" id="pname"  name="pname" value="${item.pname}">
    </div>
    <div class="form-group">
      <label for="description">Description</label>
      <input type="text" class="form-control" id="description"  name="description" value="${item.description}">
    </div>
    <div class="form-group">
      <label for="price">Price:</label>
      <input type="text" class="form-control" id="price"  name="price" value="${item.price}">
    </div>
    <div class="form-group">
      <label for="Stock">Stock:</label>
      <input type="text" class="form-control" id="stock"  name="stock" value="${item.stock}">
    </div>
    <div class="form-group">
        <label for="cname" class="col-sm-2 control-label" >Select Category</label>
        <div class="">
         <select name="cid" class="form-control" >
            <option value="">Select Category</option>
          <c:forEach items="${list}" var="cat">
          <option value="${cat.cid}">${cat.cname}</option></c:forEach>
          </select>
        </div>
      </div>
       <div class="form-group">
        <label for="supplierName" class="col-sm-2 control-label" >Select Supplier</label>
        <div class="">
         <select name="sid" class="form-control" >
            <option value=" ">Select Supplier</option>
          <c:forEach items="${slist}" var="sale">
          <option value="${sale.sid}">${sale.supplierName}</option></c:forEach>
          
            </select>
        </div>
      </div>
    <div class="form-group">
      <label for="file" class="col-sm-2 control-label">Upload Image:</label>
      <input type="file" class="form-control" id="file"  name="file" accept="image/*">
    </div>
    <button type="submit" value="saveProd1" class="btn btn-default">Submit</button>
  </form>
</div>
   

</body>
</html>