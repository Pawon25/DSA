// 217. Contains Duplicate
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: true
// Explanation:
// The element 1 occurs at the indices 0 and 3.

// Example 2:
// Input: nums = [1,2,3,4]
// Output: false
// Explanation:
// All elements are distinct.

// Example 3:
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true

// Constraints:
// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109

import java.util.Arrays;

public class Fifteen {
    private boolean isDup(int[] arr){
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==arr[i+1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] test1 = {1,2,3,1};
        Fifteen problem = new Fifteen();
        System.out.println(problem.isDup(test1));
    }
}

// Can also implement a set. if set.length < arr.length then arr will have duplicate element.
