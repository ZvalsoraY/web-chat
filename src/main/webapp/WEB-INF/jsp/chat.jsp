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
            <h1>Список пользователей</h1>
                    <table>
                        <tr>
                            <th>login</th>
                            <th>password</th>
                            <th>Online</th>
                        </tr>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.login}</td>
                                <td>${user.password}</td>
                                <td>${user.isOnline()}</td>
                            </tr>
                        </c:forEach>
                    </table>

            <div align="center">
                        <c:forEach var="message" items="${messages}">
                            <tr>
                                <td>${message.sender} send: "${message.message}"</td>
                            </tr>
                        </c:forEach>

                        <form method="post" action="chat?command=send_message">
                            <input type="text" name="message" placeholder="Message text">
                            <br/>
                            <button type="submit">Send</button>
                        </form>
            </div>
            </form>
                         <c:if test="${user.userType == 'ADMIN'}">
                            <a href="chat?command=SHOW_ADMIN_SETTINGS_PAGE">Admin settings page</a>
                         </c:if>

            <a href="chat?command=logout">Выход</a>

            <!-- Главная страница Чата -->

        </div>
    </body>
</html>