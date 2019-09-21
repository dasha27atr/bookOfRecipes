<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>User registration</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link rel="stylesheet" type="text/css" href="../css/homePage.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div id="logo">
            <h3><a href="#">Book of Recipes</a></h3>
            <h6><a href="#">Recipes Website</a></h6>
        </div>
        <!-- end div#logo -->
    </div>
    <!-- end div#header -->
    <div id="menu">
        <nav class="navbar navbar-light" style="background-color: #CC4646;">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link active" href="../home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#modal">Sign in</a>
                    <div id="modal" class="modal fade">
                        <div class="modal-dialog modal-content">
                            <div class="modal-body">
                                <form class="login-page" action="${pageContext.request.contextPath}/book" method="post">
                                    <input type="hidden" name="command" value="sign_in"/>
                                    <div class="login-page">
                                        <button class="close" data-dismiss="modal">x</button>
                                        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                                        <div class="form-group">
                                            <label for="inputLogin">Login</label>
                                            <input type="text" name="login" class="form-control" id="inputLogin"
                                                   placeholder="Enter login" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword">Password</label>
                                            <input type="password" name="password" class="form-control"
                                                   id="inputPassword" placeholder="Enter password" required>
                                        </div>
                                        <div class="form-check">
                                            <input type="checkbox" class="form-check-input" id="check">
                                            <label class="form-check-label" for="check">Remember me</label>
                                        </div>
                                        <input type="submit" class="btn btn-danger btn-lg-6" name="login"
                                               value="Sign in"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="jsp/registration.jsp">Sign up</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light" type="submit">Search</button>
            </form>
        </nav>
    </div>
    <!-- end div#menu -->
    <div id="page">
        <div id="page-bgtop">
            <div id="content">
                <div class="registration">
                    <br>
                    <h3>User registration</h3><br>
                    <h6>
                        After registration, you can add recipes and photos to the site, write reviews and communicate
                        with other project participants.
                    </h6>
                    <form id="registration-form" method="post" action="${pageContext.request.contextPath}/book">
                        <input type="hidden" name="command" value="sign_up"/>
                        <div class="registration-page">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="setLogin">Login</label>
                                    <input type="text" name="login" size="10" class="form-control"
                                           id="setLogin" placeholder="Login" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="setPassword">Password</label>
                                    <input type="text" name="password" size="10" class="form-control"
                                           id="setPassword" placeholder="Password" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="setEmail">E-mail</label>
                                <input type="text" name="email" class="form-control"
                                       id="setEmail" placeholder="E-mail" required>
                            </div>
                            <div class="form-group">
                                <label for="setAddress">Address</label>
                                <input type="text" name="address" class="form-control"
                                       id="setAddress" placeholder="Address" required>
                            </div>
                            <div class="form-group">
                                <label for="setPhone">Phone</label>
                                <input type="text" name="phone" class="form-control"
                                       id="setPhone" placeholder="Phone" required>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="setFirstName">First Name</label>
                                    <input type="text" name="firstName" class="form-control"
                                           id="setFirstName" placeholder="First Name" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="setLastName">Last Name</label>
                                    <input type="text" name="lastName" class="form-control"
                                           id="setLastName" placeholder="Last Name" required>
                                </div>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="termsCheck" required>
                                <label class="form-check-label" for="termsCheck">Agree to terms and conditions</label>
                            </div>
                            <br>
                            <div class="btn-group row" role="group">
                                <input type="submit" class="btn btn-danger" name="registration" value="Submit">
                                &ensp;
                                <button type="button" class="btn btn-danger">
                                    <a href="home.jsp" style="color: #FFFFFF">Exit</a>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- end div#content -->
            <div id="sidebar">
                <ul>
                    <li>
                        <br>
                        <h2 class="categories">Lorem Ipsum</h2>
                        <div class="card" style="width: 12rem; height: 23rem;">
                            <img src="http://www.good-cook.ru/articles/2016/07/16-1-domashnyaya-eda.jpg"
                                 class="card-img-top" alt="food">
                            <div class="card-body">
                                <h5 class="card-title">Название карточки</h5>
                                <p class="card-text">Some quick example text to build on the card title and make up the
                                    bulk of the card's content.</p>
                                <br>
                                <button type="button" class="btn btn-danger">
                                    <a href="#" style="color: #FFFFFF">Переход куда-нибудь</a>
                                </button>
                            </div>
                        </div>
                    </li>
                    <li>
                        <br>
                        <h2>Volutpat Dolore</h2>
                        <div class="card" style="width: 12rem; height: 23rem;">
                            <img src="https://static.1000.menu/img/content/24774/sloenyi-desert-v-stakane_1514977480_1_max.jpg"
                                 class="card-img-top" alt="food">
                            <div class="card-body">
                                <h5 class="card-title">Название карточки</h5>
                                <p class="card-text">Some quick example text to build on the card title and make up the
                                    bulk of the card's content.</p>
                                <br>
                                <button type="button" class="btn btn-danger">
                                    <a href="#" style="color: #FFFFFF">Переход куда-нибудь</a>
                                </button>
                            </div>
                        </div>
                    </li>
                    <li>
                        <br>
                        <h2>Bebindum Mauris </h2>
                        <div class="card" style="width: 12rem; height: 23rem;">
                            <img src="https://img.poehali.tv/img/2018-11-12/fmt_114_24_shutterstock_1195703299.jpg"
                                 class="card-img-top" alt="food">
                            <div class="card-body">
                                <h5 class="card-title">Название карточки</h5>
                                <p class="card-text">Some quick example text to build on the card title and make up the
                                    bulk of the card's content.</p>
                                <br>
                                <button type="button" class="btn btn-danger">
                                    <a href="#" style="color: #FFFFFF">Переход куда-нибудь</a>
                                </button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <!-- end div#sidebar -->
            <div style="clear: both; height: 1px"></div>
        </div>
    </div>
    <!-- end div#page -->
    <div id="footer">
        <p>Copyright &copy; 2007 Culinary. All Rights Reserved. Designed by <a href="http://www.freecsstemplates.org/">Free
            CSS Templates</a>.&nbsp;&nbsp;<a href="#">Privacy Policy</a> | <a href="#">Terms of Use</a></p>
    </div>
    <!-- end div#footer -->
</div>
<!-- end div#wrapper -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
