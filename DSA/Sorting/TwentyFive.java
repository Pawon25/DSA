// Permute two arrays such that sum of every pair is greater or equal to K
// Given two arrays of equal size n and an integer k. The task is to permute both arrays such that sum of their corresponding element is greater than or equal to k i.e a[i] + b[i] >= k. The task is to print "Yes" if any such permutation exists, otherwise print "No".

// Input : a[] = {2, 1, 3}, 
//         b[] = { 7, 8, 9 }, 
//         k = 10. 
// Output : Yes
// Permutation  a[] = { 1, 2, 3 } and b[] = { 9, 8, 7 } 
// satisfied the condition a[i] + b[i] >= K.

// Input : a[] = {1, 2, 2, 1}, 
//         b[] = { 3, 3, 3, 4 }, 
//         k = 5. 
// Output : No

// Try it on GfG Practice
// The idea is to sort one array in ascending order and another array in descending order and if any index does not satisfy the condition a[i] + b[i] >= K then print "No", else print "Yes".

// If the condition fails on sorted arrays, then there exists no permutation of arrays that can satisfy the inequality. Proof,
// Assume asort[] be sorted a[] in ascending order and bsort[] be sorted b[] in descending order. 

// Let new permutation b[] is created by swapping any two indices i, j of bsort[], 

// Case 1: i < j and element at b[i] is now bsort[j]. 
// Now, asort[i] + bsort[j] < K, because bsort[i] > bsort[j] as b[] is sorted in decreasing order and we know asort[i] + bsort[i] < k.
// Case 2: i > j and element at b[i] is now bsort[j]. 
// Now, asort[j] + bsort[i] < k, because asort[i] > asort[j] as a[] is sorted in increasing order and we know asort[i] + bsort[i] < k.
// Below is the implementation is this approach: 

import java.util.*;
public class TwentyFive{
    public static int[] asc(int[] arr){
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        return arr;
    }

    public static int[] dec(int[] arr){
        Arrays.sort(arr);
        for(int i=0;i<arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 -i];
            arr[arr.length - 1 -i] = temp;
        }
        System.out.println("\nAfter desc"+ "==\n");
        for(int i=0;i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        return arr;
    }

    public static boolean checkPermuteValid(int[] a, int[]b, int k){
        for(int i=0;i<a.length;i++){
            if(a[i]+b[i] != k){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] a = {1, 2, 2, 1};
        int[] b = { 3, 3, 3, 4 };
        int k = 5;
        asc(a);
        dec(b);
        //So i need to check where all permutations is greater than k;
        System.out.println("Result "+ (checkPermuteValid(a,b,k)? "Yes": "No"));
    }
}