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
            url: "/Tewst_05/showList", // URL của servlet
            type: "GET",
            data: {
                accountId: accountId
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML += data;
            },
            error: function (xhr, status, error) {
                console.log("Error: " + error);
            }
        });
    }


});
