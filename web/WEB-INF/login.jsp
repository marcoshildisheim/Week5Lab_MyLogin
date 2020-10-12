<%-- 
    Document   : login
    Created on : Oct 11, 2020, 6:16:02 PM
    Author     : 820203
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="login" method="POST">
            Username: <input type="text" name="username" value="${username}" /><br>
            Password: <input type="password" name="password" value="${password}" /><br>
            
            <input type="submit" value="submit" />
        </form>
            <p>${message}</p>    
    </body>
</html>
