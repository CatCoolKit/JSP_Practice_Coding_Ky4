<%-- 
    Document   : index
    Created on : Jan 22, 2024, 1:32:15 PM
    Author     : manhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/TagTest" prefix="tagtest"%>
<%@taglib uri="/WEB-INF/tlds/tagCustom" prefix="tagcustom"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>

        <div class="container mt-3">
            <h1 id="header_1">Login your account</h1>
            <h5 id="header_1"><tagtest:XuLy/></h5>
            <tagcustom:custom textColor="red">Button</tagcustom:custom>

                <p>Login for services, enter your id and password below. Then, click on the Submit button.</p>

                <form action="login" method="post">
                    <div class="mb-3 mt-3">
                        <label class="userID">UserId: </label>
                        <input type="text" name="userID" id="userID" value="" required><br>

                    </div>
                    <div class="mb-3">
                        <label class="password">PassWord:</label>
                        <input type="password" name="password" id="password" value="" required><br>
                        <span id="passwordError" style="color: red;"></span>
                    </div>
                    <div class="form-check mb-3">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" name="remember"> Remember me
                        </label>
                    </div>
                    <button type="submit" name="action" value="loginUser" class="btn btn-primary" onclick="validateForm(event)">Submit</button>
                </form>
            </div>

        <%
            if (session != null) {
                // Lấy giá trị của thuộc tính loginStatus từ HttpSession
                String loginStatus = (String) session.getAttribute("loginStatus");
                // Kiểm tra nếu loginStatus bằng "failed" thì in ra thông báo đăng nhập thất bại
                if ("failed".equals(loginStatus)) {
        %>
        <div class="container mt-3">
            <span class="badge rounded-pill bg-secondary">You have failed to log in ${sessionScope.loginAttempts} times. If you fail to log in more than 5 times, you will be locked out for 10 minutes.</span>
        </div>
        <%
                }
            }
            // Các trường hợp khác có thể được xử lý tại đây
%>

        <script>
            function validateForm(event) {
                console.log("validateForm is called");
                var passwordInput = document.getElementById("password");
                var passwordError = document.getElementById("passwordError");

                // Kiểm tra xem mật khẩu chỉ chứa số hay không
                if (!/^\d+$/.test(passwordInput.value)) {
                    passwordError.innerHTML = "Password must only be entered in numbers.";
                    event.preventDefault(); // Ngăn chặn form được gửi đi
                    return false;
                } else {
                    passwordError.innerHTML = ""; // Xóa thông báo lỗi nếu có
                    return true; // Cho phép form được gửi đi
                }
            }

//            function showMessage() {
//                alert("Welcom to we page!");
//            }
//            document.addEventListener("DOMContentLoaded", function () {
//                showMessage();
//            });
        </script>


    </body>

</html>
