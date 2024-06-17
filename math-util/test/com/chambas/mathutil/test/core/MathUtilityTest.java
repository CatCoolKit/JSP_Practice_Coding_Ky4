/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chambas.mathutil.test.core;

import com.chambas.mathutil.core.MathUtil;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author manhc
 */
public class MathUtilityTest {
    
    @Test
    public void testGetFactorialGivenRightArgumentReturnWell() {
        long expected = 120;
        int n = 5;
        long actual = MathUtil.getFactorial(n);
        
        assertEquals(expected, actual);
        assertEquals(1, MathUtil.getFactorial(1));
        assertEquals(2, MathUtil.getFactorial(2));
        assertEquals(6, MathUtil.getFactorial(3));
        assertEquals(24, MathUtil.getFactorial(4));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenWrongArgumentThrowException() {

        long actual = MathUtil.getFactorial(-5);
    }
    
//    @Test
//    public void testGetFactorialGivenWrongArgumentThrowException_LambdaVersion() {
//
//        //Assert.assertThrows();
//    }
    
    @Test
    public void testGetFactorialGivenWrongArgumentThrowException_TryCatch() {

        try {
            long actual = MathUtil.getFactorial(-5);   
        } catch (Exception e) {
            Assert.assertEquals("Invalid argument. N must be between 0..20", e.getMessage());
        }
    }
    
}
