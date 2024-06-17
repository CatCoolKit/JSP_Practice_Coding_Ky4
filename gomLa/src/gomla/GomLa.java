/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomla;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author manhc
 */
public class GomLa {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        Stack<Integer> stack = new Stack<>();

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

//        while (!stack.isEmpty()) {
//            current.next = new ListNode(stack.pop());
//            current = current.next;
//        }
        return dummy.next;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int longestLenght = 0, right = 0, left = 0;
        int start = 1;

        while (right < n) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                longestLenght = Math.max(longestLenght, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }

            // Kiểm tra xem chuỗi con hiện tại có lớn hơn chuỗi con tốt nhất đã biết không
            if (right - left > longestLenght) {
                start = left;
                longestLenght = right - left;
            }
        }
        System.out.println(s.substring(start, start + longestLenght));

        for (Character character : set) {
            System.out.print(character);
        }

        return longestLenght;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1 + length2];
        double ab = 0;

        // Gộp hai mảng vào mảng kết quả
        System.arraycopy(nums1, 0, result, 0, length1);
        System.arraycopy(nums2, 0, result, length1, length2);

        // Sắp xếp mảng kết quả
        Arrays.sort(result);

        for (int i : result) {
            System.out.print(i);
        }
        System.out.println("");
        System.out.println(result.length);

        int median = result.length / 2;
        if (result.length % 2 == 0) {
            ab = (double) (result[median] + result[median - 1]) / 2;
        } else {
            ab = result[median];
        }

        return ab;
    }

    private int start = 0;
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            expandAroundCenter(s, i, i); // For odd length palindromes
            expandAroundCenter(s, i, i + 1); // For even length palindromes
        }

        return s.substring(start, start + maxLength);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int currentLength = right - left - 1;
        if (currentLength > maxLength) {
            start = left + 1;
            maxLength = currentLength;
        }
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        // Khởi tạo mỗi hàng với một StringBuilder
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean goingDown = false;

        // Duyệt qua chuỗi và thêm ký tự vào các hàng tương ứng
        for (char c : s.toCharArray()) {
            rows[row].append(c);
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }
            row += goingDown ? 1 : -1;
        }

        // Gom tất cả các hàng lại để tạo ra chuỗi kết quả
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : rows) {
            result.append(stringBuilder);
        }

        return result.toString();
    }

    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Kiểm tra xem reversed có vượt quá giới hạn của kiểu Integer không
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Nếu vượt quá, trả về 0
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Nếu vượt quá, trả về 0
            }

            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
        int digit = 0;

        // Convert digits to integer
        for (char object : s.toCharArray()) {
            if (index < s.length() && Character.isDigit(object) || (object == '+' || object == '-')) {
                // Handle sign
                if ((object == '+' || object == '-')) {
                    sign = (object == '-') ? -1 : 1;
                } else {
                    digit = object - '0';

                    // Check for overflow
                    if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }

                    total = total * 10 + digit;
                }

                index++;
            }
        }
        return total * sign;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return original == reversed;
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] indicates if s.substring(0, i) matches p.substring(0, j)
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // Empty string matches empty pattern

        // Initialize dp[0][j] for patterns like "a*", "a*b*", etc.
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (sc == pc || pc == '.') { // If current characters match
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') { // If current pattern character is '*'
                    if (dp[i][j - 2]) { // Zero occurrences of the preceding character
                        dp[i][j] = true;
                    } else if (p.charAt(j - 2) == sc || p.charAt(j - 2) == '.') {
                        // One or more occurrences of the preceding character
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int x = num;
        int sum = 0;
        Hashtable<Integer, String> list = new Hashtable<>();
        list.put(1, "I");
        list.put(2, "II");
        list.put(3, "III");
        list.put(4, "IV");
        list.put(5, "V");
        list.put(6, "VI");
        list.put(7, "VII");
        list.put(8, "VIII");
        list.put(9, "IX");
        list.put(10, "X");
        list.put(40, "XL");
        list.put(50, "L");
        list.put(90, "XC");
        list.put(100, "C");
        list.put(400, "CD");
        list.put(500, "D");
        list.put(900, "CM");
        list.put(1000, "M");
        for (int object : list.keySet()) {
            if (object >= x) {
                result.append(list.get(object));
                x -= object;
            }
        }

        return result.toString();
    }

    public static int romanToInt(String s) {
        // Create a hashmap to store the values of Roman numerals
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // Iterate through the characters of the Roman numeral string
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = map.get(c);

            // If the value of the current character is less than the previous character,
            // it means subtraction is required
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }

        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values of nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicate values of nums[left]
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate values of nums[right]
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }

        return result;
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(result, map, digits, 0, new StringBuilder());

        return result;
    }

    private void backtrack(List<String> result, Map<Character, String> map, String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            backtrack(result, map, digits, index + 1, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicate values of nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // Skip duplicate values of nums[left]
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Skip duplicate values of nums[right]
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

        }

        return result;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move the first pointer ahead by n+1 nodes
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers together until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next;

        return dummy.next;
    }

    // Tính UCLN bằng đệ quy
    public static int ucln(int a, int b) {
        if (b == 0) {
            return a;
        }
        return ucln(b, a % b);
    }

    // Tính BCNN bằng đệ quy
    public static int bcnn(int a, int b) {
        return (a * b) / ucln(a, b);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append remaining nodes from l1 or l2
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head nodes of all lists to the min heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Continuously extract the smallest node from the heap and add it to the result list
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode prev = dumy;
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;

        }

        return dumy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // Base case: if the list has less than k nodes, return the head as it is
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        // Divide the list into two parts: the first k nodes and the remaining nodes
        ListNode curr = head;
        ListNode end = head;
        ListNode prev1 = end;
        for (int i = 0; i < k; i++) {
            if (end == null) {
                return head;
            }
            //end = end.next;
            head.next = new ListNode(76);
        }

        // Reverse the first k nodes
        ListNode prev = end;
        ListNode next = null;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Recursively reverse the remaining nodes
        head.next = reverseKGroup(curr, k);

        // Return the head of the reversed first k nodes
        return prev;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //Arrays.sort(nums);
        List<Integer> a = new ArrayList<>();
        int uniqueCount = 1; // Initialize with 1 since the first element is always unique
        int slowPointer = 0; // Slow pointer
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[slowPointer]) {
                slowPointer++;
                nums[slowPointer] = nums[i];
                uniqueCount++;
            }
//              if(!a.contains(nums[i])){
//              uniqueCount++;
//              a.add(nums[i]);
//              }
        }
        // Modify the array to contain only the unique elements at the beginning
        for (int i = uniqueCount; i < nums.length; i++) {
            nums[i] = '_';
        }

        return uniqueCount;
    }

    public int removeElement(int[] nums, int val) {
        int k = 0; // Initialize the count of elements not equal to val
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i]; // Place non-val elements at the position indicated by k
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = '_';
        }
        return k; // Return the count of elements not equal to val
    }

    public String strStr(String haystack, String needle) {
        String result = "";
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int k = 0;
            while (k < needle.length() && haystack.charAt(i + k) == needle.charAt(k)) {
                k++;
            }
            if (k == needle.length()) {
                result += i + ","; // Found the needle at index i
            }
        }
        return result;
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        // Determine the sign of the result
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long quotient = 0;
        long tempDivisor, multiple;

        while (absDividend >= absDivisor) {
            tempDivisor = absDivisor;
            multiple = 1;
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            absDividend -= tempDivisor;
            quotient += multiple;
        }

        quotient *= sign;

        // Handle overflow
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) quotient;
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int start = 0; start <= s.length() - totalLength; start++) {
            HashMap<String, Integer> seen = new HashMap<>();
            int i = start;
            while (i < start + totalLength) {
                String word = s.substring(i, i + wordLength);
                if (!wordCount.containsKey(word) || (seen.getOrDefault(word, 0) >= wordCount.get(word))) {
                    break;
                }
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                i += wordLength;
            }
            if (i == start + totalLength) {
                result.add(start);
            }
        }

        return result;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the first decreasing element from right to left
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If no such element found, reverse the entire array
        if (i == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the smallest element greater than nums[i] using Binary Search
        int j = binarySearch(nums, i + 1, n - 1, nums[i]);

        // Step 4: Swap nums[i] and nums[j]
        if (j != -1) {
            swap(nums, i, j);
        }

        // Step 5: Reverse the elements from index i+1 onwards
        reverse(nums, i + 1, n - 1);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int longestValid = 0;
        int start = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {  //c == ')'
                if (stack.isEmpty()) {
                    start = i + 1;// Update starting index of next potential valid substring
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        longestValid = Math.max(longestValid, i - start + 1);
                    } else {
                        longestValid = Math.max(longestValid, i - stack.peek());
                    }
                }

            }
        }
        return longestValid;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1}; // Khởi tạo mảng kết quả với giá trị mặc định là [-1, -1]
        int left = 0;
        int right = nums.length - 1;

        // Tìm vị trí bắt đầu của target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
                right = mid - 1; // Tiếp tục tìm kiếm vị trí bắt đầu bên trái
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Tìm vị trí kết thúc của target
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            //int mid = left + (right - left) / 2;
            if (nums[left] == target) {
                res[1] = left;
                //left = mid + 1; // Tiếp tục tìm kiếm vị trí kết thúc bên phải
            }
            left += 1;

        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GomLa gl = new GomLa();
        int[] a = {1, 1};
        System.out.println(Arrays.toString(gl.searchRange(a, 1))); // Output: [1, 3, 2]

    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

}
