<nav class="navbar navbar-inverse">
  <div class="container-fluid">  
    <div class="navbar-header"> 
     <a class="navbar-brand" >A STORE</a>             
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">              
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
        </button>
      </div>        
      <div class="collapse navbar-collapse" id="myNavbar">
   <ul class="nav navbar-nav">     
   <li><a href="">Home</a></li>
   <li><a href="adding">Admin</a></li>

   <li><a  href="productAdminList">Admin List</a></li>
  
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:forEach items="${list}" var="cat">
          <!-- <option value="${cat.cid}">${cat.cname}</option>-->
          <li><a href="productCustList?cid=${cat.cid}"  onclick="productCustList">${cat.cname} </a></li>
          </c:forEach>
        
        </ul>
    </li>
     
         
       
      
  
        <li><a href="register">Register</a></li>
        <li><a href="login">Login</a>
   
   
    </ul> 
     </div>
  
 </nav>  
 