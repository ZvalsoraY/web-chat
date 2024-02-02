<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Чат</title>
    </head>
    <body>
        <hr/>
            Hello ${user.name}, enjoy you stay.
        <hr/>
        <div align="center">
            <c:forEach items="${messages}" var="message">
                <tr>
                    <td>${message.sender}</td>
                    <td>${message.message}</td>
                </tr>
            </c:forEach>
            <form action="chat" method="post">
                <input type="text" name="message" placeholder="Message text">
                <br/>
                <button type="submit">Send</button>
            </form>

            <a href="chat?command=logout">Выход</a>

            <!-- Главная страница Чата -->

        </div>
    </body>
</html>