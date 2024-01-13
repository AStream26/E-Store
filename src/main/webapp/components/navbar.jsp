
<nav class="navbar navbar-expand-lg navbar-dark navbar-color">
    <div class="container-fluid">
        
        <a class="navbar-brand pl-5" href="/MyShop">MyShop</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse d-lg-flex justify-content-end" id="navbarSupportedContent">
    <ul class="navbar-nav">
      <li class="nav-item active pr-5">
        <a class="nav-link" href="#">Cart <span class="sr-only">(current)</span></a>
      </li>
      
      <c:choose>
          
          <c:when test='${requestScope.currentUser == null}'>
            <li class="nav-item pr-4">
                <a class="nav-link" href="/MyShop/login.jsp" >Login</a>
            </li>
            <li class="nav-item pr-4">
                 <a class="nav-link" href="/MyShop/register.jsp">Signup</a>
            </li>
          </c:when>
            
            <c:otherwise>
            <li class="nav-item pr-4">
                <div class="dropdown">
                    <img src="/MyShop/images/default.jpg" alt="This is a profile icon" class="img-thumbnail rounded-circle profile" >
                    <button class="btn btn-outline-light dropdown-toggle dropdown-custom" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      ${requestScope.currentUser.getName().split(" ")[0]}
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item"  style="color:#343a40!important;"href="#">Profile</a>
                        <a class="dropdown-item" href="/MyShop/logout" style="color:#343a40!important;">Logout</a>
                    </div>
                </div>
<!--                <a class="nav-link" href="login.jsp"></a>-->
            </li>
            </c:otherwise>
          
      </c:choose>
               
    </ul>
   
  </div>
    </div>
</nav>