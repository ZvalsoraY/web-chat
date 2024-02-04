<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Admin</title>
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
                <th>Select BAN</th>
            </tr>
                <c:forEach items="${users}" var="user">
                <tr>
                                        <td>${user.login}</td>
                                        <td>${user.password}</td>
                                        <td>${user.isReadOnly()}</td>
                                        <td>
                                         <form method="POST" action="chat?command=BAN">
                                         <input id="userLogin" type="text" type="hidden" name="userLogin" value="${user.login}">
                                        <c:if test="${user.readOnly}">
                                                                <button type="submit">Can Write</button>
                                                            </c:if>
                                                            <c:if test="${!user.readOnly}">
                                                                 <button type="submit">ReadOnly</button>
                                                            </c:if ></td>
                                    </tr>
                                </c:forEach>
         </table>


        <div align="center">
            <a href="chat?command=logout">Exit</a>
            <a href="chat?command=show_chat_page">Return chat list</a>
            <!-- Admin Page -->

        </div>

        <a href="chat?command=logout">Выход</a>
    </body>
</html>