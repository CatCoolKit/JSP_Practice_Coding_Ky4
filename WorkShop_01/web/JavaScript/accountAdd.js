/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('formUI').addEventListener('submit', function (event) {
        // Kiểm tra tất cả các trường
        var account = document.getElementById('account').value.trim();
        var pass = document.getElementById('pass').value.trim();
        var firstName = document.getElementById('firstName').value.trim();
        var lastName = document.getElementById('lastName').value.trim();
        var phone = document.getElementById('phone').value.trim();
        var birthday = document.getElementById('birthday').value.trim();
        var gender = document.querySelector('input[name="gender"]:checked');
        var roleInSystem = document.getElementById('roleInSystem').value;
        var formUI = document.getElementById('formUI');
        // Kiểm tra số điện thoại bằng biểu thức chính quy
        var phoneNumberPattern = /(0[3|5|7|8|9])+([0-9]{8})\b/g; // Biểu thức chính quy cho số điện thoại

        // Kiểm tra xem có trường nào trống không
        if (account === '' || pass === '' || firstName === '' || lastName === '' || phone === '' || birthday === '') {
            // Ngăn chặn việc submit form
            event.preventDefault();

            // Hiển thị thông báo yêu cầu điền đầy đủ thông tin
            alert('Please fill in all fields.');
        } else if (!phoneNumberPattern.test(phone)) {
            // Nếu số điện thoại không hợp lệ, hiển thị thông báo và không gửi biểu mẫu
            alert("Invalid phone number! Please enter a valid phone number.");
            // Ngăn chặn việc submit form
            event.preventDefault();
        } else {
            event.preventDefault();
            // Gửi yêu cầu Ajax để kiểm tra tài khoản
            $.ajax({
                url: "checkAccountExistence",
                type: "POST",
                data: {account: account,
                    phone: phone
                },
                success: function (response) {
                    if (response.accountExists) {
                        // Nếu tài khoản đã tồn tại, hiển thị thông báo lỗi
                        alert("Account already exists! Please choose another account.");
                    }else if (response.phoneExists) {
                        alert("Phone already exists! Please choose another phone.");
                    } else {
                        // Nếu tài khoản không tồn tại, submit biểu mẫu
                        formUI.submit();
                        alert("Account successfully created!");
                    }
                },
                error: function (xhr, status, error) {
                    console.error("Lỗi: ", error); // Xử lý lỗi nếu có
                }
            });
        }
    });
});


function validateForm(event) {

}