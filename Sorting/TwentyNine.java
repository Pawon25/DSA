// Ceiling in a sorted array
// Given a sorted array and a value x, find index of the ceiling of x. The ceiling of x is the smallest element in an array greater than or equal to x.
// Note: In case of multiple occurrences of ceiling of x, return the index of the first occurrence.

// Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
// Output: 2
// Explanation: Smallest number greater than 5 is 8, whose index is 2.

// Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 20
// Output: -1
// Explanation: No element greater than 20 is found. So output is -1.

// Input: arr[] = [1, 1, 2, 8, 10, 10, 12, 19], x = 0
// Output: 0
// Explanation: Smallest number greater than 0 is 1, whose indices are 0 and 1. The index of the first occurrence is 0.

public class TwentyNine {
    public static void main(String[] args) {
        int x = 0;
        int[] arr = {1,2,8,10,10,12,19};
        int ceiling = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if(i == 0 && arr[i] >= x){
                ceiling = i;
            }
            else if(arr[i] >= x && arr[i-1]< x){
                ceiling = i;
            }
        }
        System.out.println(ceiling);
    }
}
