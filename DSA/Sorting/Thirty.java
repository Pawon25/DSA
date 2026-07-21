// Pair with the given difference
// Last Updated : 28 Mar, 2025
// Given an unsorted array and an integer x, the task is to find if there exists a pair of elements in the array whose absolute difference is x. 

// Examples: 

// Input: arr[] = [5, 20, 3, 2, 50, 80], x = 78
// Output: Yes
// Explanation: The pair is {2, 80}.

// Input: arr[] = [90, 70, 20, 80, 50], x = 45
// Output: No
// Explanation: No such pair exists.
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Using Sorting approach
// public class Thirty{
//     public static void main(String[] args){
//         int[] arr = {5, 20, 3, 2, 50, 80};
//         int x = 78;
//         System.out.println(findPair(arr, x));
//     }

//     public static boolean findPair(int[] arr, int x) {
//         Arrays.sort(arr);
//         int i = 0, j = 1;
//         while (i < arr.length && j < arr.length) {
//             if (i != j && arr[j] - arr[i] == x) {
//                 return true;
//             } else if (arr[j] - arr[i] < x) {
//                 j++;
//             } else {
//                 i++;
//             }
//         }
//         return false;
//     }

// }
