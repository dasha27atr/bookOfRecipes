<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.04.2019
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html ; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <title>Форма входа в систему</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Dasha</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/fruits">Store<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/basket">Basket<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <form action="Registration" method="post">
            <button class="btn btn-success" type="submit" name="registration">Sign In</button>
        </form>
    </div>
</nav>
<h1>Вход в систему</h1>
<form action="Registration" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Username:</label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="Username"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
        </div>
    </div>
    <input type="submit" class="btn btn-success" name="registration" value="Зарегистрироваться">
    <input type="submit" class="btn btn-success" name="login" value="Войти в систему">
</form>

