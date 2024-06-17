/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateForm(event) {
    // Kiểm tra tất cả các trường
        var categoryName = document.getElementById('categoryName').value.trim();
        var memo = document.getElementById('memo').value.trim();
        var formCT = document.getElementById('formCT');
        var target = event.target;
        var typeId = target.value.split('#')[1];
        var status = target.value.split('#')[0];
        
        console.log(typeId);
        console.log(status);

        // Kiểm tra xem có trường nào trống không
        if (categoryName === '' || memo === '') {
            // Ngăn chặn việc submit form
            event.preventDefault();

            // Hiển thị thông báo yêu cầu điền đầy đủ thông tin
            alert('Please fill in all fields.');
          } 
          else {

            event.preventDefault();
            // Gửi yêu cầu Ajax để kiểm tra tài khoản
            $.ajax({
                url: "checkCategoryExistence",
                type: "POST",
                data: {categoryName: categoryName,
                    status: status
                },
                success: function (response) {
                    if (response.categoryExists) {
                        alert("Category already exists! Please choose another category.");
                    } else {

                        formCT.submit();
                        alert("Update successfully!");
                    }

                },
                error: function (xhr, status, error) {
                    console.error("Lỗi: ", error); // Xử lý lỗi nếu có
                }
            });
        }
}