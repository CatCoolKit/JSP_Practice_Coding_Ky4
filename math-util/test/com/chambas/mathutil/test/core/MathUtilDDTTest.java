/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chambas.mathutil.test.core;

import com.chambas.mathutil.core.MathUtil;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author manhc
 */

@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
    
    @Parameterized.Parameters //JUnit ngam chay loop qua tung dong
    public static Object[][] initData(){
        return new Integer[][]{
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 120}
        };
    }
    
    public MathUtilDDTTest() {
    }
    
    @Parameterized.Parameter(value = 0) //map voi mang data
    public int n;
    
    @Parameterized.Parameter(value = 1)
    public long expected;
    
    @Test
    public void testGetFactorialGivenRightArgumentReturnWell() {
        assertEquals(expected,  MathUtil.getFactorial(n));
    }
    
}
