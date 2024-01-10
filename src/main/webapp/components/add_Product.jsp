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
        <form>
            <div class="form-group">
              <input type="text" class="form-control" id="product name" placeholder="Product Name">
            </div>

            <div class="form-group">
                <textarea class="form-control" id="product-description" placeholder="Product Description"></textarea>
            </div>
            
            <div class="form-group">
                <input type="text" class="form-control" id="product-price" placeholder="Enter Price of Product">
            </div>
            
            <div class="form-group">
                <select class="form-control" >
                    <option selected>Choose Category</option>
                    <option>Laptop</option>
                    <option>Mobile</option>
                    <option>Kitchen</option>
            </select>
            </div>
            
            <div class="form-group">
                <input type="number" class="form-control" id="product-quantity" placeholder="Enter Price Quantity">
            </div>
            
             <div class="form-group">
                <label for="product-image">Upload Product Image</label>
                <input type="file" class="form-control-file" id="product-image">
            </div>
            
        </form>
      </div>
      <div class="modal-footer d-flex justify-content-center ">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary custom-bg">Add Product</button>
      </div>
    </div>
  </div>
</div>