// Chocolate Distribution Problem
// Last Updated : 25 Feb, 2025
// Given an array arr[] of n integers where arr[i] represents the number of chocolates in ith packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that: 
// Each student gets exactly one packet.
// The difference between the maximum and minimum number of chocolates in the packets given to the students is minimized.

// Input: arr[] = {7, 3, 2, 4, 9, 12, 56}, m = 3 
// Output: 2 
// Explanation: If we distribute chocolate packets {3, 2, 4}, we will get the minimum difference, that is 2. 

// Input: arr[] = {7, 3, 2, 4, 9, 12, 56}, m = 5 
// Output: 7
// Explanation: If we distribute chocolate packets {3, 2, 4, 9, 7}, we will get the minimum difference, that is 9 - 2 = 7. 
import java.util.Arrays;
public class Sixteen{
    public static void main(String[] args){
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        System.out.println(findMinDiff(arr, m));
        int[] testcase2 = {7, 3, 2, 4, 9, 12, 56};
        int m2 = 5;
        System.out.println(findMinDiff(testcase2, m2));
    }

    public static int findMinDiff(int[] arr, int m){
        Arrays.sort(arr);
        int windowStart = 0;
        int windowEnd = m-1;
        int minDiff = Integer.MAX_VALUE;
        while(windowEnd < arr.length){
            int diff = arr[windowEnd] - arr[windowStart];
            minDiff = Math.min(minDiff, diff);
            windowStart++;
            windowEnd++;
        }
        return minDiff;
    }
}