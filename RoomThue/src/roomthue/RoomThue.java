/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomthue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author manhc
 */
public class RoomThue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        FileReader fr = new FileReader("exp1.txt");
        BufferedReader br = new BufferedReader(fr);

        // Đọc input
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] brr = new int[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            arr[i] = Integer.parseInt(line[0]);
            brr[i] = Integer.parseInt(line[1]);

        }

        //Tính toán
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = brr[i] - arr[i];
        }
        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[i] < temp[j]) {
                    int temp1 = temp[i];
                    temp[i] = temp[j];
                    temp[j] = temp1;
                }
            }
        }
        int result = 0;
        int hour0 = 0;
        int hour24 = 24;
        int[] crr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                    if (temp[i] == (brr[j] - arr[j])) {
                        
                        for (int k = 0; k < n; k++) {
                            if(arr[k] == arr[j] && brr[k] == brr[j]){
                            result += temp[i];
                            //System.out.println(result + " " + temp[i]);
                            arr[j] = 0;
                            brr[j] = 0;
                            break;
                            }
                        }
                    }
                
            }
        }
        
        

        // Xuất output
//        for (int i = 0; i < n; i++) {
//            System.out.println(temp[i]);
//        }
//        System.out.println(result);

        int[][] requests = {{1, 2}, {3, 5}, {0, 4}, {6, 8}, {7, 13}, {4, 6}, {9, 10}, {9, 12}, {11, 14}, {15, 19}, {14, 16}, {18, 20}};
        System.out.println(solve(requests));
    }
    
    public static int solve(int[][] requests) {
            int n = requests.length;
            int[] dp = new int[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (requests[i][0] >= requests[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + (requests[i][1] - requests[i][0]));
                    }
                }
            }

        return dp[n - 1];
    }

}
