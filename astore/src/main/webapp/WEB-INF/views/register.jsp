<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>



    
    <form method="post" action="saveCat" modelAttribute="user" >
  <div class="form-group">
      <label  for="email">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email ID"  name="email">
  </div>
    <div class="form-group">
      <label  for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
      <div class="form-group">
      <label  for="address">Address:</label>
      <input type="text" class="form-control" id="address" placeholder="Enter address" name="address">
    </div>
    <div class="form-group">
      <label  for="phone">Phone no:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter phone no" name="phone">
    </div>
    
     <div class="form-group">
      <label  for="password">Password:</label>
      <input type="password" class="form-control" id="password" name="password">
    </div>
    
    <button type="submit" value="save" class="btn btn-default">Submit</button>
  </form>
      
  
   
   
   
</body>
</html>