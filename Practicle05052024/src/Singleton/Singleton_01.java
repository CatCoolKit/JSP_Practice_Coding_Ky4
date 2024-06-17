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
public final class Singleton_01 {

    private static Singleton_01 instance;

    private Singleton_01() {
    }

    ;

    public static Singleton_01 getInstance(String string) {
        System.out.println(string);
        if (instance == null) {
            synchronized (Singleton_01.class) {
                if (instance == null) {
                    instance = new Singleton_01();
                    System.out.println(string);
                }
            }
        }
        return instance;
    }

}
