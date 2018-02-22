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
<title>Admin products list</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div class="container">            
  <table class="table">
    <thead>
      <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Product Image</th>
        <th>Action </th>        
      </tr>
    </thead>
    <tbody>
      
      <c:forEach items="${abc}" var="cat">
      <tr>
        <td>${cat.pid}</td>
        <td>${cat.pname}</td>  
        <td><img src="${contextRoot}${cat.imgname}" width="100" height="100" alt="No imag available"></td>    
        <td><a href="${pageContext.request.contextPath}/updateProd?pid=${cat.pid}"> Edit </a>/<a href="${pageContext.request.contextPath}/deleteProd?pid=${cat.pid}">Delete</a></td>
          </tr>
        </c:forEach>           
    </tbody>
  </table>  
</div>
</body>
</html>