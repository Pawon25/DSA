// Searching in an array where adjacent differ by at most k
// Last Updated : 29 Mar, 2024
// A step array is an array of integers where each element has a difference of at most k with its neighbor. Given a key x, we need to find the index value of x if multiple-element exist to return the first occurrence of the key.
 

// Input : arr[] = {4, 5, 6, 7, 6}
//            k = 1
//            x = 6
// Output : 2
// The first index of 6 is 2.

// Input : arr[] = {20, 40, 50, 70, 70, 60}  
//           k = 20
//           x = 60
// Output : 5
// The index of 60 is 5

 

// This problem is mainly an extension of Search an element in an array where difference between adjacent elements is 1.
// A Simple Approach is to traverse the given array one by one and compare every element with the given element 'x'. If matches, then return index.
// The above solution can be Optimized using the fact that the difference between all adjacent elements is at most k. The idea is to start comparing from the leftmost element and find the difference between the current array element and x. Let this difference be 'diff'. From the given property of the array, we always know that x must be at least 'diff/k' away, so instead of searching one by one, we jump 'diff/k'. 
// Below is the implementation of the above idea.

import java.util.Arrays;

public class TwentyEight {
    public static int[] sortArr(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
    public static int getStartIndx(int[] arr, int k, int x){
        int i = 0;
        
        while (i < arr.length) {
            
            // If x is found at index i
            if (arr[i] == x)
                return i;

            // Jump the difference between 
            // current array element and x
            // divided by k We use max here
            // to make sure that i moves 
            // at-least one step ahead.
            i = i + Math.max(1, Math.abs(arr[i] 
                                      - x) / k);
        }

        System.out.println("number is " + 
                                "not present!");
        return -1;

    }
    public static void main(String[] args) {
        int[] test1 = {4, 5, 6, 7, 6};
        int k = 1;
        int x = 6;
        int result = getStartIndx(test1, k, x);
        System.out.println(result);
    }
}


//Grok
public static boolean isStepArray(int[] arr, int k) {
    for (int i = 0; i < arr.length - 1; i++) {
        if (Math.abs(arr[i] - arr[i + 1]) > k) {
            return false;
        }
    }
    return true;
}

public static int getStartIndx(int[] arr, int k, int x) {
    if (arr == null || arr.length == 0) {
        System.out.println("Array is empty or null!");
        return -1;
    }
    if (!isStepArray(arr, k)) {
        System.out.println("Array does not satisfy step array property!");
        return -1; // Or implement linear search
    }
    int i = 0;
    while (i < arr.length) {
        if (arr[i] == x) return i;
        i += Math.max(1, (int) Math.ceil(Math.abs(arr[i] - x) / (double) k));
    }
    System.out.println("Number is not present!");
    return -1;
}
