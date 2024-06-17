/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chambas.mathutil.core;

/**
 *
 * @author manhc
 */
public class MathUtil {
    //hàm thư viện xài chung cho ai đó, ko cần lưu lại trạng thái/giá trị
    //chọn thiết kế là static
    
    //hàm tính giai thừa
    //n! = 1.2.3.4... n
    
    public static long getFactorial(int n){
        if(n < 0 || n > 20)
            throw new IllegalArgumentException("Invalid argument. N must be between 0..20");
        
        if(n == 0 || n == 1)
            return 1;
        
        long product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }
}
