<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.04.2019
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Страница успешного входа в систему</title>
</head>
<body>
<br>
<h1>Вход посетителя в систему прошел успешно</h1>
<jsp:useBean id="user" class="by.training.finalproject.entity.User" scope="application"/>
Пользователь: <%=user.getLogin()%><br>
Email: <%=user.getEmail()%><br>
Адрес: <%=user.getAddress()%><br>
Телефон: <%=user.getPhone()%><br>
</body>
</html>
