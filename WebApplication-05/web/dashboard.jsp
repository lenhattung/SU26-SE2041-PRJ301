<%-- 
    Document   : a.jsp
    Created on : May 18, 2026, 8:09:31 AM
    Author     : tungln
--%>

<%@page import="model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome ${user.fullName}</h1> 
        You have successfully logged in.
        <hr/>
        <a href="user-form.jsp">Add User</a>
    </body>
</html>
