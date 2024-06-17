/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('formCT').addEventListener('submit', function (event) {
        // Kiểm tra tất cả các trường
        var categoryName = document.getElementById('categoryName').value.trim();
        var memo = document.getElementById('memo').value.trim();
        var formCT = document.getElementById('formCT');

        // Kiểm tra xem có trường nào trống không
        if (categoryName === '' || memo === '') {
            // Ngăn chặn việc submit form
            event.preventDefault();

            // Hiển thị thông báo yêu cầu điền đầy đủ thông tin
            alert('Please fill in all fields.');
        } else {
            event.preventDefault();
            // Gửi yêu cầu Ajax để kiểm tra tài khoản
            $.ajax({
                url: "checkCategoryExistence",
                type: "POST",
                data: {categoryName: categoryName},
                success: function (response) {
                    if (response.categoryExists) {
                        alert("Category already exists! Please choose another category.");
                    } else {
                        
                        formCT.submit();
                        alert("Category successfully created!");
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