<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../components/header.jsp" %>

<div class="container">
     <br/>
     <br/>
      <%@include file="../components/message.jsp" %>
   <div class="row dashboard-list">
    
    <div class="col-12 col-sm-6 col-md-4 ">
        <div class="card p-3 d-flex">
            <div class="d-flex justify-content-center">
                <img class="card-img-top w-50" src="/MyShop/images/box.png" alt="Card image cap">
            </div>
          <div class="card-body d-flex flex-column">
              <div class="font-weight-bold mx-auto">
                  <h4>1234</h4>
              </div>
              
              <div class="font-weight-bold mx-auto">
                  <h2>PRODUCTS</h>
              </div>
          </div>
        </div>
    </div>
    <div class="col-12 col-sm-6 col-md-4 dashboard-list ">
      
       <div class="card p-3 d-flex">
            <div class="d-flex justify-content-center">
                <img class="card-img-top w-50" src="/MyShop/images/users.png" alt="Card image cap">
            </div>
          <div class="card-body d-flex flex-column">
              <div class="font-weight-bold mx-auto">
                  <h4>1234</h4>
              </div>
              
              <div class="font-weight-bold mx-auto">
                  <h2>USERS</h2>
              </div>
          </div>
        </div>
    </div>
    <div class="col-12 col-sm-6 col-md-4 dashboard-list ">
      
        <div class="card p-3 d-flex">
            <div class="d-flex justify-content-center">
                <img class="card-img-top w-50" src="/MyShop/images/category.png" alt="Card image cap">
            </div>
          <div class="card-body d-flex flex-column">
              <div class="font-weight-bold mx-auto">
                  <h4>${sessionScope.categoryList.size()}</h4>
              </div>
              
              <div class="font-weight-bold mx-auto">
                   <h2>CATEGORY</h2>
              </div>
          </div>
        </div>  
   </div>
   </div>
     <br/><!-- comment -->
     <br/>
  <div class="row dashboard-list">
      <div class="col-1"></div>
    <div class="col-12 col-sm-5 " data-toggle="modal" data-target="#add-category">
       <div class="card p-3 d-flex">
            <div class="d-flex justify-content-center">
                <img class="card-img-top w-50" src="/MyShop/images/add-category.png" alt="Card image cap">
            </div>
          <div class="card-body d-flex flex-column">
             <div class=" mx-auto">
                  Click here to add category
              </div>
              <div class=" mx-auto">
                 <h2>ADD CATEGORY</h2>
              </div>
          </div>
        </div>
    </div>
    <div class="col-12 col-sm-5" data-toggle="modal" data-target="#add-product">
      
       <div class="card p-3 d-flex">
            <div class="d-flex justify-content-center">
                <img class="card-img-top w-50" src="/MyShop/images/add-product.png" alt="Card image cap">
            </div>
          <div class="card-body d-flex flex-column">
              <div class=" mx-auto">
                  Click here to add product
              </div>
              
              <div class=" mx-auto">
                  <h2>ADD PRODUCT</h2>
              </div>
          </div>
        </div>
    </div>
      <div class="col-1"></div>
     
  </div>
</div>
   
<%@include file="../components/add_category.jsp" %>
<%@include file="../components/add_Product.jsp" %>



<%@include file="../components/footer.jsp" %>