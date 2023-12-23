<%@include file="components/header.jsp" %>
    
<div class="container p-4 mt-5">
       
         <div class="row">
             <div class="col-md-2"></div>
        <div class="col-md-6 card p-md-4">
             <div class="card-body m-2">
            <div class="text-center">
                <h1 class="text-login">Sign Up Here</h1>
            </div>
             <form> 
                     <div class="form-group">
                      <label for="name">Name</label>
                      <input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Email address</label>
                      <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                      <small id="emailHelp" class="form-text text-muted">Enter your email address.</small>
                    </div>
                 
                    <div class="form-group">
                      <label for="mobile number">Mobile Number</label>
                      <input type="tel" class="form-control" id="mobile number" aria-describedby="mobile number help" placeholder="Enter mobile number">
                    </div>
                    
                     <div class="form-group">
                      <label for="exampleInputPassword1">Password</label>
                      <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>
                 <div class="d-flex justify-content-center">
                      <button type="submit" class="btn btn-color btn-submit">create Account</button>
                 </div>
                </form>
        </div>
               </div>
              <div class="col-md-2"></div>
       
    </div>
        

</div>


<%@include file="components/footer.jsp" %>