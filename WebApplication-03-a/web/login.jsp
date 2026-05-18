<%-- 
    Document   : index
    Created on : May 18, 2026, 7:20:07 AM
    Author     : tungln
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginController" method="POST">
            Username: <input type="text" name="userID" />
            </br>
            Password: <input type="password" name="password" />
            </br>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
