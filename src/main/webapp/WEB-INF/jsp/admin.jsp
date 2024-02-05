<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Admin page</title>
    </head>

    <body>
        <hr/>
            Hello ${user.name}, enjoy you stay.
        <hr/>
        <h1>Users list</h1>
        <table>
            <tr>
                <th>Login</th>
                <th>Password</th>
                <th>Read Only</th>
                <th>Write mode</th>
            </tr>
            <ul class="user-list" name="users-list">
                <c:forEach items="${users}" var="userL">
                    <tr>
                        <td>${userL.login}</td>
                        <td>${userL.password}</td>
                        <td>${userL.isReadOnly()}</td>
                        <td>
                            <form method="POST" action="chat?command=ban">
                                <input type="hidden" name="userLLogin" value="${userL.login}">
                                <button type="submit">Enable/Disable</button>
                            </form>
                    </tr>
                </c:forEach>
                </ul>
         </table>

        <a href="chat?command=show_chat_page">Return chat list</a>
        <br/>
        <a href="chat?command=logout">Exit</a>
    </body>
</html>