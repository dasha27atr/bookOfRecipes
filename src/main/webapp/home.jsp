<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Book of Recipes</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="css/homePage.css" rel="stylesheet" type="text/css"/>
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
                    <a class="nav-link active" href="#">Home</a>
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
            <li class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light" type="submit">Search</button>
            </li>
        </nav>
    </div>
    <!-- end div#menu -->
    <div id="page">
        <div id="page-bgtop">
            <div id="content">
                <div class="post">
                    <br>
                    <h2 class="title"><a href="#">Lorem Ipsum Dolor Volutpat</a></h2>
                    <p class="byline">Posted by FreeCssTemplates</p>
                    <div class="entry">
                        <p>This is <strong>Culinary</strong>, a free, fully standards-compliant CSS template designed by
                            <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>, released for free under
                            the <a href="http://creativecommons.org/licenses/by/2.5/">Creative Commons Attribution
                                2.5</a> license. The photo used in this template is from <a
                                    href="http://www.pdphoto.org">PDPhoto.org</a>. You're free to use this template for
                            anything as long as you link back to <a href="http://www.freecsstemplates.org/">my site</a>.
                            Enjoy :)</p>
                    </div>
                    <div class="meta">
                        <p class="links"><a href="#" class="comments">Comments (32)</a></p>
                    </div>
                </div>
                <div class="post">
                    <h2 class="title"><a href="#">Lorem Ipsum Dolor Volutpat</a></h2>
                    <p class="byline">Posted by FreeCssTemplates</p>
                    <div class="entry">
                        <p>Curabitur tellus. Phasellus tellus turpis, iaculis in, faucibus lobortis, posuere in, lorem.
                            Donec a ante. Donec neque purus, adipiscing id, eleifend a, cursus vel, odio. Vivamus varius
                            justo sit amet leo. Morbi sed libero. Vestibulum blandit augue at mi. Praesent fermentum
                            lectus eget diam. Nam cursus, orci sit amet porttitor iaculis, ipsum massa aliquet nulla,
                            non elementum mi elit a mauris.</p>
                    </div>
                    <div class="meta">
                        <p class="links"><a href="#" class="comments">Comments (32)</a></p>
                    </div>
                </div>
                <div class="post">
                    <h2 class="title"><a href="#">Praesent scelerisque scelerisque</a></h2>
                    <p class="byline">Posted by FreeCssTemplates</p>
                    <div class="entry">
                        <p>Curabitur tellus. Phasellus tellus turpis, iaculis in, faucibus lobortis, posuere in, lorem.
                            Donec a ante. Donec neque purus, adipiscing id, eleifend a, cursus vel, odio. Vivamus varius
                            justo sit amet leo. Morbi sed libero. Vestibulum blandit augue at mi. Praesent fermentum
                            lectus eget diam. Nam cursus, orci sit amet porttitor iaculis, ipsum massa aliquet nulla,
                            non elementum mi elit a mauris.</p>
                    </div>
                    <div class="meta">
                        <p class="links"><a href="#" class="comments">Comments (32)</a></p>
                    </div>
                </div>
                <div class="post">
                    <h2 class="title"><a href="#">Fusce ultrices fringilla</a></h2>
                    <p class="byline">Posted by FreeCssTemplates</p>
                    <div class="entry">
                        <p>Curabitur tellus. Phasellus tellus turpis, iaculis in, faucibus lobortis, posuere in, lorem.
                            Donec a ante. Donec neque purus, adipiscing id, eleifend a, cursus vel, odio. Vivamus varius
                            justo sit amet leo. Morbi sed libero. Vestibulum blandit augue at mi. Praesent fermentum
                            lectus eget diam. Nam cursus, orci sit amet porttitor iaculis, ipsum massa aliquet nulla,
                            non elementum mi elit a mauris.</p>
                    </div>
                    <div class="meta">
                        <p class="links"><a href="#" class="comments">Comments (32)</a></p>
                    </div>
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
