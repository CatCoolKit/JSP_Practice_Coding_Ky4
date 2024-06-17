/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication48;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author manhc
 */
public class JavaApplication48 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        //Pattern p = Pattern.compile("^[0-9]+{6,10}$"); //dấu cộng là cho nhập nhiều ký tự, {} giới hạn số lượng ký tự nhập vào ở đây là 6 đến 10
        Pattern p = Pattern.compile("^[a-zA-Z0-9 ]+{6,10}$");
        while (true) {
            System.out.print("Nhap mot so: ");
            String text = sc.nextLine();
            System.out.println(text);
            if (p.matcher(text).find()) {
                System.out.println("ok");
                break;
            } else {
                System.out.println("not ok");
            }
        }

        System.out.print("Nhập kích thước của mảng: ");
        int kichThuoc = sc.nextInt();

        // Khai báo mảng với kích thước đã nhập
        int[] mangSoNguyen = new int[kichThuoc];

        // Nhập giá trị cho từng vị trí trong mảng
        for (int i = 0; i < kichThuoc; i++) {
            System.out.print("Nhập giá trị cho phần tử thứ " + i + ": ");
            mangSoNguyen[i] = sc.nextInt();
        }

        // Hiển thị mảng sau khi nhập
        System.out.println("Mảng sau khi nhập:");
        for (int i = 0; i < kichThuoc; i++) {
            System.out.println("Phần tử thứ " + i + ": " + mangSoNguyen[i]);
        }

    }

}
