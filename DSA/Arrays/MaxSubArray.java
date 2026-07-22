// Problem 1 — Arrays: Maximum Subarray Sum

// Given an integer array, find the contiguous subarray with the largest sum, and return that sum.

// Example: [-2,1,-3,4,-1,2,1,-5,4] → 6 (subarray [4,-1,2,1])

public class MaxSubArray{
    public static int findLargestSumOfSubArray(int[] arr){

        if(arr == null || arr.length == 0){
            return 0;
        }

        int maxSum = arr[0];
        int currentSum = arr[0];

        for(int i =1; i< arr.length; i++){
            currentSum = Math.max(arr[i], currentSum+arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] Args){
        int[] example = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = findLargestSumOfSubArray(example);
        System.out.println("Sum = "+ sum);
    }
}