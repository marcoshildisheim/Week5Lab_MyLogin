<%-- 
    Document   : home
    Created on : Oct 11, 2020, 6:15:48 PM
    Author     : 820203
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h2>Welcome ${user.username}</h2>
        <a href="login?logout">Logout</a>
    </body>
</html>
