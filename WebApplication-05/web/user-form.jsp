<%-- 
    Document   : user-form.jsp
    Created on : May 25, 2026, 8:44:30 AM
    Author     : Le Nhat Tung
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thêm người dùng</title>
</head>
<body>

<h2>Thêm người dùng</h2>

<form action="AddUserController" method="post">
    <input type="hidden" name="action" value="addUser">

    <table>
        <tr>
            <td>Mã người dùng:</td>
            <td><input type="text" name="userID" required></td>
        </tr>
        <tr>
            <td>Họ và tên:</td>
            <td><input type="text" name="fullName" required></td>
        </tr>
        <tr>
            <td>Mật khẩu:</td>
            <td><input type="password" name="password" required></td>
        </tr>
        <tr>
            <td>Vai trò:</td>
            <td>
                <select name="roleID">
                    <option value="ADMIN">Admin</option>
                    <option value="USER">User</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Trạng thái:</td>
            <td><input type="checkbox" name="status" value="true" checked> Hoạt động</td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Thêm">
            </td>
        </tr>
    </table>

</form>

</body>
</html>