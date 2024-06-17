/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




function validateForm(event) {
    // Kiểm tra tất cả các trường
        var account = document.getElementById('account').value.trim();
        var pass = document.getElementById('pass').value.trim();
        var firstName = document.getElementById('firstName').value.trim();
        var lastName = document.getElementById('lastName').value.trim();
        var phone = document.getElementById('phone').value.trim();
        var birthday = document.getElementById('birthday').value.trim();
        var gender = document.querySelector('input[name="gender"]:checked');
        var roleInSystem = document.getElementById('roleInSystem').value;
        var isUse = document.getElementById('isUse');
        var formUI = document.getElementById('formUI');

        var target = event.target;
        var acId = target.value.split('#')[1];
        var status = target.value.split('#')[0];

        // Kiểm tra xem có trường nào trống không
        if (account === '' || pass === '' || firstName === '' || lastName === '' || phone === '' || birthday === '') {
            // Ngăn chặn việc submit form
            event.preventDefault();

            // Hiển thị thông báo yêu cầu điền đầy đủ thông tin
            alert('Please fill in all fields.');
        } else {
            event.preventDefault();
            // Gửi yêu cầu Ajax để kiểm tra tài khoản
            $.ajax({
                url: "checkAccountExistence",
                type: "POST",
                data: {account: account,
                    phone: phone,
                    status: status
                },
                success: function (response) {
                    if (response.phoneExists) {
                        alert("Phone already exists! Please choose another phone.");
                    } else {
                        // Nếu tài khoản không tồn tại, submit biểu mẫu
                        formUI.submit();
                        alert("Update successfully!");
                    }
                },
                error: function (xhr, status, error) {
                    console.error("Lỗi: ", error); // Xử lý lỗi nếu có
                }
            });
        }
}

