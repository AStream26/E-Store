<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="add-product" tabindex="-1" role="dialog" aria-labelledby="add-product" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header custom-bg">
                <h5 class="modal-title" id="add-product">Add New Product</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="/MyShop/product" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="text" class="form-control" id="product name" placeholder="Product Name" name="pName">
                    </div>

                    <div class="form-group">
                        <textarea class="form-control" id="product-description" placeholder="Product Description" name="pDesp"></textarea>
                    </div>

                    <div class="form-group">
                        <input type="text" class="form-control" id="product-price" placeholder="Enter Price of Product" name="pPrice">
                    </div>

                    <div class="form-group">
                        <select class="form-control" name="pCategory" >
                            <option selected>Choose Category</option>
                            <c:forEach var="category" items="${sessionScope.categoryList}">
                                <option value=${category.getCategoryId()}>${category.getCategoryName()}</option>
                            </c:forEach>
                          
                        </select>
                    </div>

                    <div class="form-group">
                        <input type="number" class="form-control" id="product-quantity" placeholder="Enter Price Quantity" name="pQuantity">
                    </div>

                    <div class="form-group">
                        <label for="product-image">Upload Product Image</label>
                        <input type="file" class="form-control-file" id="product-image" name="pImage">
                    </div>



                    <div class="modal-footer d-flex justify-content-center ">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary custom-bg">Add Product</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>