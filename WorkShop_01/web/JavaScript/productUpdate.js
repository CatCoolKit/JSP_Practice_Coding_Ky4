/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateForm(event) {
    var formPD = document.getElementById('formPD');
    var productId = document.getElementById('productId');

    // Kiểm tra tất cả các trường
    var productId = document.getElementById('productId').value.trim();
    var productName = document.getElementById('productName').value.trim();
    var productImage = document.getElementById('productImage').value.trim();
    var brief = document.getElementById('brief').value.trim();
    var type = document.getElementById('type').value.trim();
    var account = document.getElementById('account').value.trim();
    var unit = document.getElementById('unit').value.trim();
    var price = document.getElementById('price').value.trim();
    var discount = document.getElementById('discount').value.trim();

    var target = event.target;
    var prId = target.value.split('#')[1];
    var status = target.value.split('#')[0];

    console.log(prId);
    console.log(status);

    // Kiểm tra xem có trường nào trống không
    if (productId === '' || productName === '' || productImage === '' || brief === ''
            || unit === '' || price === '' || discount === '') {
        // Ngăn chặn việc submit form
        event.preventDefault();

        // Hiển thị thông báo yêu cầu điền đầy đủ thông tin
        alert('Please fill in all fields.');
    } else {
        event.preventDefault();
        // Gửi yêu cầu Ajax để kiểm tra tài khoản
        $.ajax({
            url: "checkProductExistence",
            type: "POST",
            data: {productId: productId,
                status:status
            },
            success: function (response) {
                if (response.productExists) {
                    alert("ProductId already exists! Please choose another productId.");
                } else {

                    formPD.submit();
                    alert("ProductId successfully created!");
                }
            },
            error: function (xhr, status, error) {
                console.error("Lỗi: ", error); // Xử lý lỗi nếu có
            }
        });
    }
}