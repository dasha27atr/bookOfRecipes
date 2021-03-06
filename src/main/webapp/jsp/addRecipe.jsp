<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.04.2019
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>User account</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="../css/homePage.css" rel="stylesheet" type="text/css"/>
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
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#modal">Exit</a>
                    <div id="modal" class="modal fade">
                        <div class="modal-dialog modal-content">
                            <div class="modal-body sign-out">
                                <button class="close" data-dismiss="modal">x</button>
                                <h4 class="h4 mb-3 font-weight-normal">Are you sure you want to sign out?</h4>
                                <div class="btn-group" role="group">
                                    <button type="button" class="btn btn-danger">
                                        <a href="../home.jsp">Yes</a>
                                    </button>
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
                                </div>
                            </div>
                        </div>
                    </div>
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
                <br>
                <h3>Add recipe</h3><br>
                <form id="add-recipe-page" method="post" action="${pageContext.request.contextPath}/book">
                    <input type="hidden" name="command" value="add_recipe"/>
                    <div class="add-recipe-page">
                        <div class="row">
                            <div class="form-group col-md-6">
                                <div class="col-md-6">
                                    <br>
                                    <div class="form-group">
                                        <label for="setTitle">Title</label>
                                        <input type="text" name="title" class="form-control"
                                               id="setTitle" placeholder="Title" required>
                                    </div>
                                    <label>
                                        <select name="category" required>
                                            <option value="hot_dishes">Hot dishes</option>
                                            <option value="salads">Salads</option>
                                            <option value="snacks">Snacks</option>
                                            <option value="soups">Soups</option>
                                            <option value="baking">Baking</option>
                                            <option value="desserts">Desserts</option>
                                            <option value="drinks">Drinks</option>
                                        </select>
                                    </label>
                                </div>
                            </div>
                            <div class="card col-md-6" style="width: 18rem;">
                                <img class="card-img-top float-md-right"
                                     src="https://icon-library.net/images/img-icon/img-icon-11.jpg"
                                     alt="user image" width="160" height="260">
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="basic-addon3">URL</span>
                                        </div>
                                        <input type="text" class="form-control" name="photo"
                                               aria-describedby="basic-addon3"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Description</span>
                            </div>
                            <textarea class="form-control" name="description" aria-label="Description"></textarea>
                        </div>
                        <br>
                        <div class="btn-group row" role="group">
                            <button type="submit" class="btn btn-danger" name="add_recipe">Submit</button>
                            &ensp;
                            <button type="button" class="btn btn-danger">
                                <a href="account.jsp" style="color: #FFFFFF">Exit</a>
                            </button>
                        </div>
                    </div>
                </form>
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
