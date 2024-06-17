/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chambas.mathutil.main;

import com.chambas.mathutil.core.MathUtil;

/**
 *
 * @author manhc
 */
public class Main {
    public static void main(String[] args) {
        
        long expected = 120;
        int n = 5;
        long actual = MathUtil.getFactorial(n);
        System.out.println("5!= " + expected + " (expected)");
        System.out.println("5! = " + actual + " (actual)");
    }
}
