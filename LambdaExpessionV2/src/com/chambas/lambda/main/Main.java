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
public class Main {
    public static void main(String[] args) {
        
        Salutation helloVN = new Salutation() {
            @Override
            public void sayHello(String msg) {
                System.out.println(msg);
            }
        };
        
        Salutation helloJP = (String msg) -> {
            System.out.println(msg);
        };
    }
}
