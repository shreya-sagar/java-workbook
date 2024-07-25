package com.dev.gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PalindromicArray {
    /**
     * Given an array arr[] of positive integers. Return true if all the array elements are palindrome otherwise, return false.
     *
     * Examples:
     *
     * Input: arr[] = [111, 222, 333, 444, 555]
     * Output: true
     * Explanation:
     * arr[0] = 111, which is a palindrome number.
     * arr[1] = 222, which is a palindrome number.
     * arr[2] = 333, which is a palindrome number.
     * arr[3] = 444, which is a palindrome number.
     * arr[4] = 555, which is a palindrome number.
     * As all numbers are palindrome so This will return true.
     * Input: arr[] = [121, 131, 20]
     * Output: false
     * Explanation: 20 is not a palindrome hence the output is false.
     * Expected Time Complexity: O(nlogn)
     * Expected Space Complexity: O(1)
     *
     * Constraints:
     * 1 <=arr.size<= 20
     * 1 <=arr[i]<= 105
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Long> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = (int) i;

            System.out.println(palinArray(arr) ? "true" : "false");
        }
    }

    //TODO : Complete this method
    private static boolean palinArray(int[] arr) {
        return false;
    }
}
