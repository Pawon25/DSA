// Maximum and Minimum Element in an Array

// Given an array, the task is to find the maximum and the minimum element of the array using the minimum number of comparisons.

// Examples:
// Input: arr[] = {3, 5, 4, 1, 9}
// Output: Minimum element is: 1
//               Maximum element is: 9
// Input: arr[] = {22, 14, 8, 17, 35, 3}
// Output:  Minimum element is: 3
//               Maximum element is: 35


import java.util.Arrays;
class Twelve{
    private int[] getExtreams(int[] arr){
        if(arr.length == 0){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int min = Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }else if(arr[i]>max){
                max = arr[i];
            }
        }
        return new int[]{min, max};
    }

    private int[] getExtreamsBySorting(int[] arr){
        if(arr.length == 0){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        Arrays.sort(arr);
        return new int[]{arr[0], arr[arr.length - 1]};
    }

    static class Pair {

        int min;
        int max;
    }

    // static Pair getMinMax(int arr[], int n) {
    //     Pair minmax = new  Pair();
    //     int i;

    //     /*If there is only one element then return it as min and max both*/
    //     if (n == 1) {
    //         minmax.max = arr[0];
    //         minmax.min = arr[0];
    //         return minmax;
    //     }

    //     /* If there are more than one elements, then initialize min 
    // and max*/
    //     if (arr[0] > arr[1]) {
    //         minmax.max = arr[0];
    //         minmax.min = arr[1];
    //     } else {
    //         minmax.max = arr[1];
    //         minmax.min = arr[0];
    //     }

    //     for (i = 2; i < n; i++) {
    //         if (arr[i] > minmax.max) {
    //             minmax.max = arr[i];
    //         } else if (arr[i] < minmax.min) {
    //             minmax.min = arr[i];
    //         }
    //     }

    //     return minmax;
    // }
    public static void main(String[] args){
        System.out.println("Hello, World!");
        Twelve twelve = new Twelve();
        int[] arr = {3, 5, 4, 1, 9};
        int[] extreams = twelve.getExtreams(arr);
        System.out.println("Minimum element is: " + extreams[0]);
        System.out.println("Maximum element is: " + extreams[1]);

        int[] extreamsBySorting = twelve.getExtreamsBySorting(arr);
        System.out.println("Minimum element by sorting is: " + extreamsBySorting[0]);
        System.out.println("Maximum element by sorting is: " + extreamsBySorting[1]);
    }
}


// The number of comparisons made to find the minimum and maximum elements is equal to the number of comparisons made during the sorting process.
// For any comparison-based sorting algorithm, the minimum number of comparisons required to sort an array of n elements is O(n log n).
// Hence, the number of comparisons made in this approach is also O(n log n).


// https://www.geeksforgeeks.org/dsa/maximum-and-minimum-in-an-array/
// There are two more methods in above link. 