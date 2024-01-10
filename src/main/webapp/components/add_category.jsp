<div class="modal fade" id="add-category" tabindex="-1" role="dialog" aria-labelledby="add-category" aria-hidden="true">
  <div class="modal-dialog " role="document">
    <div class="modal-content">
      <div class="modal-header custom-bg">
        <h5 class="modal-title" id="add-category">Add New Category</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="category" class="col-form-label">Category</label>
            <input type="text" class="form-control" id="category">
          </div>
          <div class="form-group">
            <label for="category-description" class="col-form-label">Description</label>
            <textarea class="form-control" id="category-description"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer d-flex justify-content-center">
        <button type="button" class="btn btn-secondary " data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary custom-bg">Add Category</button>
      </div>
    </div>
  </div>
</div>