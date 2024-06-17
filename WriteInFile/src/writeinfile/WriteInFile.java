/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writeinfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author manhc
 */
public class WriteInFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);

//        String fileName = "input.txt";
//
//        System.out.println("Số CCCD: ");
//        String cccd = reader.nextLine();
//        System.out.println("Họ và Tên: ");
//        String hoten = reader.nextLine();
//        writeToFile(fileName, hoten, cccd);
//        
//        readFromFile(fileName);
        createForm(5, 8);
        Triangle(5);

        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Mảng đã sắp xếp:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Hàm đọc dữ liệu từ file
    public static void readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File không tồn tại. Tạo file mới...");
                file.createNewFile(); // Tạo file mới nếu không tồn tại
                return; // Kết thúc hàm nếu đã tạo file mới
            }

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                // Tách dòng thành hai phần dựa vào dấu ":"
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String name = parts[0].trim(); // Phần tên
                    String phoneNumber = parts[1].trim(); // Phần số điện thoại
                    System.out.println("Tên: " + name + ", Số điện thoại: " + phoneNumber);
                } else {
                    System.out.println("Dòng không hợp lệ: " + line);
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    // Hàm ghi dữ liệu vào file
    public static void writeToFile(String fileName, String name, String cccd) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File không tồn tại. Tạo file mới...");
                file.createNewFile(); // Tạo file mới nếu không tồn tại
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            String newLine = name + " : " + cccd;
            bw.write(newLine); // Ghi dòng mới vào file
            bw.newLine(); // Xuống dòng
            bw.close();
            System.out.println("Đã ghi vào file.");
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public static void createForm(int width, int height) {

        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {

                if (i == 0 || i == width - 1) {
                    System.out.print("* ");
                } else if (j == 0 || j == height - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }

            System.out.println("");
        }
    }

    // Phương thức vẽ tam giác
    public static void Triangle(int chieuCao) {
        for (int i = 1; i <= chieuCao; i++) {
            // In khoảng trắng bên trái tam giác
            for (int j = 1; j <= chieuCao - i; j++) {
                System.out.print(" ");
            }

            // In các dấu '*' của tam giác
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            // Xuống dòng sau khi in xong một hàng
            System.out.println();
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                //đây là sắp xếp lớn trước bé sau, ngược lại thì đổi điều kiện của j : j=n-1;j>i;j--
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    //Lomuto
    public static void quickSort(int[] arr, int low, int hight) {

        if (low < hight) {
            int pivotIndex = partition(arr, low, hight);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, hight);
        }

    }

    //lomuto
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap1(arr, i, j);
            }
        }

        swap1(arr, i + 1, high);
        return i + 1;
    }

    private static void swap1(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Hoare
    private static int partition2(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);

            if (i < j) {
                swap1(arr, i, j);
            } else {
                return j;
            }

        }
    }
    
    private static void heapify(int a[], int n, int i){
        
        int l = 2*i+1;
        int r = 2*i+2;
        int largest = i;
        if(l<n && a[l]>a[largest]){
            largest = l;
        }
        
        if(r<n && a[r]>a[largest]){
            largest = r;
        }
        if(largest != i){
            swap1(a, i, largest);
            heapify(a, n, largest);
        }
    }
    
    private static void heapSort(int a[], int n){
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }
        
        for (int i = n-1; i >= 0; i--) {
            swap1(a, i, 0);
            heapify(a, i, 0);
        }
    }
    
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Không cần sắp xếp nếu mảng đã có 0 hoặc 1 phần tử
        }
        int[] helper = new int[arr.length]; // Mảng trợ giúp để lưu kết quả tạm thời
        mergeSort(arr, helper, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, helper, low, mid); // Sắp xếp nửa đầu của mảng
            mergeSort(arr, helper, mid + 1, high); // Sắp xếp nửa sau của mảng
            merge(arr, helper, low, mid, high); // Hợp nhất hai nửa đã sắp xếp
        }
    }

    private static void merge(int[] arr, int[] helper, int low, int mid, int high) {
        // Sao chép dữ liệu từ mảng gốc sang mảng trợ giúp
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }

        int i = low; // Chỉ mục cho nửa đầu của mảng
        int j = mid + 1; // Chỉ mục cho nửa sau của mảng
        int k = low; // Chỉ mục cho mảng kết quả

        // Hợp nhất hai nửa thành một mảng kết quả
        while (i <= mid && j <= high) {
            if (helper[i] <= helper[j]) {
                arr[k] = helper[i];
                i++;
            } else {
                arr[k] = helper[j];
                j++;
            }
            k++;
        }

        // Sao chép phần còn lại của nửa đầu (nếu còn)
        while (i <= mid) {
            arr[k] = helper[i];
            k++;
            i++;
        }
    }
    
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Trả về chỉ số của phần tử nếu tìm thấy
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }
    
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Trả về chỉ số của phần tử nếu tìm thấy
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }
    
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Trả về chỉ số của phần tử nếu tìm thấy
            } else if (arr[mid] < target) {
                return binarySearchRecursive(arr, target, mid + 1, right);
            } else {
                return binarySearchRecursive(arr, target, left, mid - 1);
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }
    
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n); // Số bước nhảy

        int prev = 0;
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1; // Nếu vượt quá kích thước mảng, trả về -1
            }
        }

        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1; // Nếu vượt quá kích thước mảng, trả về -1
            }
        }

        if (arr[prev] == target) {
            return prev; // Trả về chỉ số nếu tìm thấy
        }

        return -1; // Trả về -1 nếu không tìm thấy
    }
    
    public static int fibonacciSearch(int[] arr, int target) {
        int fibM2 = 0; // (m-2)th Fibonacci number
        int fibM1 = 1; // (m-1)th Fibonacci number
        int fibM = fibM2 + fibM1; // mth Fibonacci number
        int n = arr.length;
 
        while (fibM < n) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }
 
        int offset = -1;
 
        while (fibM > 1) {
            int i = Math.min(offset + fibM2, n - 1);
 
            if (arr[i] < target) {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibM2;
                fibM1 -= fibM2;
                fibM2 = fibM - fibM1;
            } else {
                return i; // Trả về chỉ số của phần tử nếu tìm thấy
            }
        }
 
        if (fibM1 == 1 && arr[offset + 1] == target) {
            return offset + 1;
        }
 
        return -1; // Trả về -1 nếu không tìm thấy
    }

}
