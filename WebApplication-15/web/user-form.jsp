<%-- 
    Document   : user-form.jsp
    Created on : May 25, 2026, 8:44:30 AM
    Author     : Le Nhat Tung
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm người dùng</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${update eq true}">
                <h2>Update user</h2>
            </c:when>
            <c:otherwise>
                <h2>Add user</h2>
            </c:otherwise>
        </c:choose>

        <form action="MainController" method="post">
            <input type="hidden" name="action" value="${update?'UpdateUser_saveUser':'addUser'}">
            <table>
                <tr>
                    <td>Mã người dùng:</td>
                    <td><input type="text" name="userID" required value="${userInput.userID}"  ${update?'readonly':''}> <span style="color: red">${userID_error}</span> </td>
                </tr>
                <tr>
                    <td>Họ và tên:</td>
                    <td><input type="text" name="fullName" required value="${userInput.fullName}"><span style="color: red">${fullName_error}</span></td>
                </tr>
                <tr>
                    <td>Mật khẩu:</td>
                    <td><input type="password" name="password" required value=""><span style="color: red">${password_error}</span></td>
                </tr>
                <tr>
                    <td>Vai trò:</td>
                    <td>
                        <select name="roleID">
                            <option value="ADMIN" ${userInput.roleID == 'ADMIN' ? 'selected' : ''}>Admin</option>
                            <option value="USER" ${userInput.roleID == 'USER' ? 'selected' : ''}>User</option>
                        </select>
                        <span style="color: red">${roleID_error}</span>
                    </td>
                </tr>
                <tr>
                    <td>Trạng thái:</td>
                    <td>
                        <input type="checkbox" name="status" value="true" ${userInput == null || userInput.status ? 'checked' : ''}> Hoạt động
                        <span style="color: red">${status_error}</span>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="${update?'Update':'Add'}">
                    </td>
                </tr>
               <tr>
                    <td>Ảnh đại diện:</td>
                    <td>
                        <div>
                            <img id="avatarPreview" 
                                 src="${not empty userInput.avatar ? userInput.avatar : 'images/default-avatar.png'}" 
                                 alt="Avatar Preview" 
                                 style="max-width: 150px; max-height: 150px; border: 1px solid #ccc; margin-bottom: 10px; display: block;"/>
                        </div>

                        <input type="file" id="avatarInput" accept="image/*">

                        <input type="hidden" name="avatarBase64" id="avatarBase64" value="${userInput.avatar}">

                        <span style="color: red">${avatar_error}</span>
                    </td>
                </tr>
            </table>
            <span style="color: red">${error}</span>
        </form>

    </body>
    
   <script>
        document.getElementById('avatarInput').addEventListener('change', function(event) {
            const file = event.target.files[0];
            if (file) {
                if (file.type.startsWith('image/')) {
                    const reader = new FileReader();

                    reader.onload = function(e) {
                        const base64String = e.target.result; // Đây chính là chuỗi dạng: data:image/jpeg;base64,...

                        // 1. Cập nhật hình ảnh hiển thị preview
                        document.getElementById('avatarPreview').src = base64String;

                        // 2. Gán chuỗi Base64 vào thẻ hidden để submit lên server
                        document.getElementById('avatarBase64').value = base64String;
                    };

                    // Đọc file dưới dạng Data URL (Base64)
                    reader.readAsDataURL(file);
                } else {
                    alert('Vui lòng chọn một file hình ảnh hợp lệ (png, jpg, jpeg,...)');
                    this.value = ''; 
                }
            }
        });
    </script>

</html>