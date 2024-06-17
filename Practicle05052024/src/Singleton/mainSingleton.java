/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

/**
 *
 * @author manhc
 */
public class mainSingleton {
    public static void main(String[] args) {
        //Singleton_01 singleton = Singleton_01.getInstance("FOO");
        //Singleton_01 singleton1 = Singleton_01.getInstance("BAR");
        
        int numberOfDisks = 3; // Số lượng đĩa
        solveHanoi(numberOfDisks, 'A', 'B', 'C'); // A là cột gốc, B là cột trung gian, C là cột đích
    }
    
    // Hàm đệ quy để giải bài toán Tháp Hà Nội
    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        // Điều kiện dừng của đệ quy: chỉ còn 1 đĩa
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Di chuyển n-1 đĩa từ cột gốc sang cột trung gian
        solveHanoi(n - 1, source, destination, auxiliary);

        // Di chuyển đĩa cuối cùng từ cột gốc sang cột đích
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Di chuyển n-1 đĩa từ cột trung gian sang cột đích
        solveHanoi(n - 1, auxiliary, source, destination);
    }
        
}

    

