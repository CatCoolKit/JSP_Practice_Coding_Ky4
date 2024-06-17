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
            url: "/WorkShop_01/listproduct", // URL của servlet
            type: "GET",
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML += data;
            },
            error: function (xhr, status, error) {
                console.log("Error: " + error);
            }
        });
    }

    window.onload = function () {
        // Lấy tất cả các phần tử có lớp 'media' trong lưới sản phẩm
        var medias = document.querySelectorAll('.media');
        

        // Khởi tạo chiều cao lớn nhất ban đầu
        var maxHeight = 0;

        // Lặp qua tất cả các phần tử 'media' để tìm chiều cao lớn nhất
        for (var i = 0; i < medias.length; i++) {
            var mediaHeight = medias[i].clientHeight;
            if (mediaHeight > maxHeight) {
                maxHeight = mediaHeight;
            }
        }

        // Đặt chiều cao lớn nhất cho tất cả các phần tử 'media'
        for (var i = 0; i < medias.length; i++) {
            medias[i].style.height = maxHeight + 'px';
        }
    };

});
