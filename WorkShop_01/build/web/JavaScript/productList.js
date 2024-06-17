/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    // Gọi hàm để tải danh sách sản phẩm khi trang được tải
    loadProducts();

    // Hàm để gửi yêu cầu AJAX đến servlet
    function loadProducts() {
        $.ajax({
            url: "/WorkShop_01/productsystem", // URL của servlet
            type: "GET",
            success: function (data) {
                var row = document.getElementById("listProd");
                row.innerHTML += data;
            },
            error: function (xhr, status, error) {
                console.log("Error: " + error);
            }
        });
    }

});

function validateForm(event) {

    var target = event.target;
    var productId = target.value.split('#')[1];
    var status = target.value.split('#')[0];
    var test = 1;

    console.log(productId);
    console.log(status);

    if (status === "DEL") {
        var target = event.target;
        // Lấy hàng chứa nút delete
        const button = target.closest('tr');
        if (confirm('Are you sure you want to delete this Account?')) {
            button.style.display = 'none';
        } else {
            test = 0;
        }
    }

    if (test === 1) {
        $.ajax({
            url: "/WorkShop_01/productsystem",
            type: "POST",
            data: {
                productId: productId,
                status: status
            },
            success: function (response) {
                if (response.success) {
                    // Xử lý thành công
                    console.log("d");
                } else {
                    console.log("s");
                }
                if (status === "UPD") {
                    window.location.href = "productUpdate.jsp";
                }
            },
            error: function () {
                alert('Có lỗi xảy ra, vui lòng thử lại sau.');
            }
        });
    }

}
