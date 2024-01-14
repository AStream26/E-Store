
<nav class="navbar navbar-expand-lg navbar-dark navbar-color">
    <div class="container-fluid">

        <a class="navbar-brand pl-5" href="/MyShop">MyShop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse d-lg-flex justify-content-end align-items-center" id="navbarSupportedContent">
            <ul class="navbar-nav d-flex align-items-center">
                <li class="nav-item pr-4 d-flex">

                    <a class="nav-link" href="#" data-toggle="modal" data-target="#cart" class="d-flex align-items-center" style="margin-bottom: -6px;padding: 0;">
                        <svg s xmlns="http://www.w3.org/2000/svg" class="cart-icon" height="40" width="30" viewBox="0 0 576 512">
                            <path  d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96zM252 160c0 11 9 20 20 20h44v44c0 11 9 20 20 20s20-9 20-20V180h44c11 0 20-9 20-20s-9-20-20-20H356V96c0-11-9-20-20-20s-20 9-20 20v44H272c-11 0-20 9-20 20z"/>
                        </svg>
                    </a>
                    <span class="badge badge-light cart-badge" class="align-self-center rounded-circle" style="height: 1rem;border-radius: 50%">
                      0
                    </span>


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