let productOp = document.querySelector("#productOp");
const cartBadge = document.querySelector(".cart-badge");
const cartBody = document.querySelector(".cart-body");
const itemTotal = document.querySelector(".total-prize");
const snackbar = document.querySelector("#snackbar");
function updateCart() {

    const cartItems = JSON.parse(localStorage.getItem("cart"));
    if (cartItems == null || cartItems?.length == 0) {
        cartBadge.innerHTML = `0`;
        cartBody.innerHTML = `<h1 class="text-secondary">Your cart is Empty</h1>`;
        return;
    }    
    cartBadge.innerHTML = `${cartItems.length}`;
    const totalPrize = cartItems.reduce((total, item) => total + Math.round(item.price * item.quantity), 0);
    let items = ` <thead>
                        <tr>
                            <th scope="col">Item Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Total Prize</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
        <tbody>`;
    cartItems.forEach((item, index) => {

        items += `
                <tr>
                       <td>${item.name}</td>
                       <td>&#8377;${item.price}</td>
                       <td>${item.quantity}</td>
                       <td>&#8377;${Math.round(item.price * item.quantity)}</td>
                       <td>
                            <div class="btn-group btn-group-sm" role="group" aria-label="add to cart" >
                                <button type="button" class="btn btn-outline-dark icon-minus">
                                   <i class="fa fa-minus removeFromCart"
                                     data-pId="${item.id}"
                                data-pname="${item.name}" 
                                data-pImage="${item.image}"
                                data-pprice="${item.price}"></i>
                                </button>
                                <button type="button" class="btn btn-outline-primary custom-bg">
                                    <i class="fa fa-plus addToCart" style="font-size:20px;color:#fff;"
                                      data-pId="${item.id}"
                                data-pIname="${item.name}" 
                                data-pImage="${item.image}"
                                data-pprice="${item.price}"></i>
                                </button>
                            </div>
                        </td>
                   </tr>
                `;
    });

    items += ` </tbody>`;
    cartBody.innerHTML = items;
    itemTotal.innerHTML = `<p class="font-weight-bold mr-3">Total Price:${totalPrize}</p>`;
    toastMessage("Iteam Added Successfully");
}

function addProductToCart(e) {

    e.preventDefault();
    const addToCart = e.target.closest(".addToCart");
    if (!addToCart)
        return;
    const id = e.target.dataset.pid;
    const name = e.target.dataset.pname;
    const price = e.target.dataset.pprice;
    const image = e.target.dataset.pimage;
    const cart = localStorage.getItem("cart");
    if (cart) {
        let cartItems = JSON.parse(cart);
        const item = cartItems.find(item => item.id === id);
        if (item) {

            cartItems.map(cur => {
                if (item.id === cur.id) {
                    cur.quantity += 1;
                }
            });
            
        } else {
            cartItems.push({
                id, name, price, image, quantity: 1
            });
        }
        localStorage.setItem("cart", JSON.stringify(cartItems));
    } else {
        let cart = [];
        const product = {
            id, name, price, image, quantity: 1
        };

        cart.push(product);
        localStorage.setItem("cart", JSON.stringify(cart));
    }

    updateCart();
}

function removeFromCart(e) {
    e.preventDefault();
    const removeFromCart = e.target.closest(".removeFromCart");
    if (!removeFromCart)
        return;
    const id = e.target.dataset.pid;
    const name = e.target.dataset.pname;
    const price = e.target.dataset.pprice;
    const image = e.target.dataset.pimage;
    const cart = localStorage.getItem("cart");
    if (cart) {
        let cartItems = JSON.parse(cart);
        const item = cartItems.find(item => item.id === id);
        if(item){
            if(item.quantity == 1){
            
            cartItems = cartItems.filter(item=> item.id !== id);
            localStorage.setItem("cart", JSON.stringify(cartItems));
             }
             else{
                cartItems.map(cur => {
                if (item.id === cur.id) {
                    cur.quantity -= 1;
                }
            });
             localStorage.setItem("cart", JSON.stringify(cartItems));
            }
        }
        
    }
    updateCart();
}




function toastMessage(message) {
    snackbar.className = "show";
    snackbar.innerHTML = message;
    setTimeout(function () {
        snackbar.className = snackbar.className.replace("show", "");
    }, 3000);
}
updateCart();
const cartOp = document.querySelector(".cartOp");
if (cartOp) {
    cartOp.addEventListener("click", function (e) {
        addProductToCart(e);
    });

    cartOp.addEventListener("click", function (e) {
        removeFromCart(e);
    });
}
if (productOp) {
    productOp.addEventListener("click", function (e) {
        addProductToCart(e);
    });
}

