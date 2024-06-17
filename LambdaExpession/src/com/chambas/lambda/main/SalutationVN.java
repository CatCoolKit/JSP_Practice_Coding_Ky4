/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chambas.lambda.main;

import com.chambas.lambda.core.Salutation;

/**
 *
 * @author manhc
 */
public class SalutationVN implements Salutation{

    @Override
    public void sayHello() {
        System.out.println("Xin chao cac ban");
    }
    
}
