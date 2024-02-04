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
        <div align="center">
            <a href="chat?command=logout">Exit</a>

            <!-- Admin Page -->

        </div>
    </body>
</html>