<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Adding</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">
   <h6>LOGIN</h6>
  <form action="login" method="post">
  <c:if test="$(not empty error)">
  <div class "error" >${error}</div>
  </c:if>
  <c:if test="$(not empty logout)">
  <div class "error">${logout}</div>
  </c:if>
  
 <div class="form-group">
    <label><b>Email:</b></label><br>
    <input type="text" placeholder="Enter email-id" name="email" required></div>
<div class="form-group">
    <label><b>Password:</b></label><br>
    <input type="password" placeholder="Enter Password" name="password" required></div>
<div class="form-group">
   <button type="Submit" name ="Submit" value="login" class="btn btn-primary btn-md">Login</button>    
    <button type="Reset" name ="Reset" value="reset" class="btn btn-primary btn-md">Reset</button>    
    </div>
    <div class="form-group">
      <input type="checkbox" checked="checked"> Remember me
      
    </div>
    </form>
  </div>
</body>
</html>