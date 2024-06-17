/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author manhc
 */
public class Validation {
    private final String PHONE_NUMBER = "^0[35789]\\d{8}";

   public Validation() {
   }

   public boolean isPhoneNumber(String s) {
      return s.matches(PHONE_NUMBER);
   }
}
