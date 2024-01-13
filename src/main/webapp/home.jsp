<%@include  file="components/header.jsp" %>

<div class="row mt-4 ml-2">
    <div class="col-md-2">
        <div class="list-group">
            <a href="#" class="list-group-item list-group-item-action active">
                All Products
            </a>
            <c:forEach var="categoryList" items="${applicationScope.categoryList}">
                <a href="#" class="list-group-item list-group-item-action">${categoryList.getCategoryName()}</a>
            </c:forEach>
        </div>
    </div>
    <div class="col-md-9">
        <div class="card-group ">
            <c:forEach var="product" items="${applicationScope.productList}">
                <div class="col-md-4 ">
                    <div class="card d-flex">
                        <div class="bg-card-hover">
                            <div class="d-flex justify-content-center m-2">
                                <img class="card-img-top w-50" style="border-radius: 1rem" src="/MyShop/images/iphone.webp"   alt="Card image cap">
                            </div>
                            <div class="card-body d-flex flex-column">
                                <h5 class="card-title">${product.getName()}</h5>

                            </div>
                        </div>
                        <div class="card-footer d-flex flex-row justify-content-center">

                            <div>
                                <button type="button" class="btn custom-bg-primary">Add To Cart</button>
                                <button type="button" class="btn btn-outline-primary">&#8377;${product.getPrice()}</button>
                            </div>
                            <!--                            <small class="text-muted">Last updated 3 mins ago</small>-->
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>

<%@include file="components/footer.jsp" %>