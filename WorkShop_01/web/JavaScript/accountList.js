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
            url: "/WorkShop_01/listaccount", // URL của servlet
            type: "GET",
            success: function (data) {
                var row = document.getElementById("listAccount");
                row.innerHTML += data;
            },
            error: function (xhr, status, error) {
                console.log("Error: " + error);
            }
        });
    }

});

function handleClick() {
    // Đoạn mã JavaScript xử lý khi liên kết được nhấp vào
    // Ví dụ: Gửi yêu cầu AJAX, thay đổi trạng thái, v.v.
    alert("Liên kết được nhấp vào!");
}

function validateForm(event) {

    var target = event.target;
    var accountId = target.value.split('#')[1];
    var isUse = target.dataset.isuse;
    var status = target.value.split('#')[0];
    var test = "xoa";

    console.log(accountId);
    console.log(isUse);
    console.log(status);

    // Cập nhật văn bản của nút
    if (isUse === "0") { // Nếu đang là Deactive
        target.innerHTML = "Active";
    } else if (isUse === "1") { // Nếu đang là Active
        target.innerHTML = "Deactive";
    }
    if (status === "DEL") {
        var target = event.target;
        // Lấy hàng chứa nút delete
        const button = target.closest('tr');
        if (confirm('Are you sure you want to delete this Account?')) {
            button.style.display = 'none';
        } else {
            test = "khongxoa";
        }
    }

    if (test === "xoa") {

        $.ajax({
            url: "acprocess",
            type: "POST",
            data: {
                accountId: accountId,
                isUse: isUse,
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
                    window.location.href = "accountUpdate.jsp";
                }
            },
            error: function () {
                alert('Có lỗi xảy ra, vui lòng thử lại sau.');
            }
        });
    }
}

