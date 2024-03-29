<%@include file="components/header.jsp" %>
    
<div class="container p-4 mt-5">
    
     <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8" style="position: relative;">
            <%@include file="components/message.jsp" %>
        </div>
         <div class="col-md-2"></div>
    </div>
    
         <div class="row">
             <div class="col-md-3"></div>
        <div class="col-md-6 card p-md-4">
             <div class="card-body m-2">
            <div class="text-center">
                <h1 class="text-login">Sign Up Here</h1>
            </div>
                 <form action="signup" method="POST"> 
                     <div class="form-group">
                      <label for="name">Name</label>
                      <input name="uname" type="text" class="form-control" id="name" aria-describedby="emailHelp" required placeholder="Enter name">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Email address</label>
                      <input name="email" type="email" class="form-control" id="exampleInputEmail1" required aria-describedby="emailHelp" placeholder="Enter email">
                      <small id="emailHelp" class="form-text text-muted">Enter your email address.</small>
                    </div>
                 
                    <div class="form-group">
                      <label for="mobile number">Mobile Number</label>
                      <input name="mobNo" type="tel" class="form-control" id="mobile number" required aria-describedby="mobile number help" placeholder="Enter mobile number">
                    </div>
                    
                     <div class="form-group">
                      <label for="exampleInputPassword1">Password</label>
                      <input name="pwd" type="password" class="form-control" required id="exampleInputPassword1" placeholder="Password">
                    </div>
                 <div class="d-flex justify-content-center">
                      <button type="submit" class="btn btn-color btn-submit">create Account</button>
                 </div>
                </form>
        </div>
               </div>
              <div class="col-md-3"></div>
       
    </div>
        

</div>


<%@include file="components/footer.jsp" %>