/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome_1;

import static java.lang.Math.abs;
import static java.lang.StrictMath.abs;
import java.util.Arrays;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author manhc
 */
public class Palindrome_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        // TODO code application logic here
        System.out.println("Nhap mot chuoi bat ky: ");
        String input = scanner.nextLine();
        int j = 0;
        int a = input.length()-1;
        char[] a1 = new char[100];
        
        for (int i = a; i >= 0; i--) {
            a1[j] = input.charAt(i);
            j++;
        }
//        for (int i = 2; i >=0; i--) {
//             a1[i] = '_';
//        }
        char[] a2 = a1;
        int b = 1;
        for (int i = a; i >= 0; i--) {
            a1[a+b-1] = a2[i];
            b++;
        }
        for (int i = 0; i < a1.length; i++) {
             System.out.print(a1[i]);
        }
        System.out.println("");
        System.out.println("==================");
//        System.out.println(a1[0]);
        //longestPalindromeSubstring1();
        
        char[] result1 = timchuoi(input);
       
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
        }
        
        System.out.println("");
        System.out.println("==================");
        
        boolean result = Ispalindrome(input);
        if (result == true) {
            System.out.println("Ispalindrom");
        }
        else {
            System.out.println("not Ispalindrom");
        }
    }

    public static Boolean Ispalindrome(String input) {
        String input1 = null;
        int length = input.length();
        StringBuilder a = null;

        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                // Nếu khác nhau, trả về false
                return false;
            }
        }

        return true;
    }
    
    public static char[] timchuoi(String s) {
        int n = s.length() - 1;
        int j = 0;
        char[] s1 = s.toCharArray();
        char[] s2 = new char[100];
        char[] s3 = new char[100];
        Stack<Character> stack = new Stack<>();

        for (int i = n; i >= 0; i--) {
            s2[j] = s.charAt(i);
            j++;
        }
        
        for (int i = 0; i <= n/2; i++) {
            
            for (int k = 0; k < n/2; k++) {
                
                if(s1[i] == s2[k] && i != n/2){
                    for (int p = k; p >=0; p--) {
                        s2[p] = '_';
                    }
                    stack.push(s1[i]);
                    s3[j] = s1[i];
                    j++;
                    break;
                }
                else if(i == n/2){
                    if(s1[i] == s2[k]){
                        s3[j] = s1[i];
                        j++;
                        s3[j] = s2[k];
                        j++;
                        for (int l = 0; l <= stack.size(); l++) {
                            s3[j] = stack.pop();
                            j++;
                        }
                        break;
                    }
//                    else if(s1[i] != s2[(n/2)-1]){
//                        s3[j] = s1[i-1];
//                        break;
//                    }
                    else {
                        s3[j] = s1[i];
                        j++;
                        for (int l = 0; l <= stack.size(); l++) {
                            s3[j] = stack.pop();
                            j++;
                        }
                        break;
                    }
                }
            }
        }
        
        System.out.println(stack);
        
        return s3;
    }
    
    public static void daonguoc(char[] input){
        int a = input.length-1; //2
        int b = a;
        int c = 1;
        char[] d = input;
        
        for (int i = a; i >= 0; i--) {
            input[a-1+c] = d[i];
            c++;
        }
    
    }
    
    public static void longestPalindromeSubstring(String s) {
    int n = s.length();
    int ans = 1;
    boolean[][] dp = new boolean[n+1][n+1];

    for (int i = 1; i <= n; i++) {
      dp[i][i] = true;
    }

    for (int cl = 2; cl <= n; cl++) {
      for (int i = 1; i < n - cl + 1; i++) {
        int j = i + cl - 1;
        if (cl == 2 && s.charAt(i) == s.charAt(j)) {
          dp[i][j] = true;
        } else {
          dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
        }
        if(dp[i][j] == true){ ans = Math.max(ans, cl); }
      }
    }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
    System.out.println(ans);

  }
    
  public static void longestPalindromeSubstring1() {
    String x = "acbaed";
    String y = "abcadf";
    
    int n = x.length(), m = y.length();
    int[][] F = new int[n+1][m+1];
    
      for (int i = 0; i <= n; i++) {
          for (int j = 0; j <= m; j++) {
              if(i == 0 || j == 0){
                  F[i][j] = 0;
              }
              else {
                  if(x.charAt(i-1) == y .charAt(j-1)){
                      F[i][j] = F[i-1][j-1]+1;
                  }
                  else {
                      F[i][j] = Math.max(F[i][j-1], F[i-1][j]);
                  }
              }
              
          }
      }
      
      System.out.println(F[n][m]);
    

  }

}
