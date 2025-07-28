// Counting Sort - Data Structures and Algorithms Tutorials

// Counting Sort is a non-comparison-based sorting algorithm. It is particularly efficient when the range of input values is small compared to the number of elements to be sorted. The basic idea behind Counting Sort is to count the frequency of each distinct element in the input array and use that information to place the elements in their correct sorted positions.

// For example, for input [1, 4, 3, 2, 2, 1], the output should be [1, 1, 2, 2, 3, 4]. The important thing to notice is that the range of input elements is small and comparable to the size of the array.
// If the max element is of order more than n Log n where n is size of the array, then we can better sort the array using a standard comparison based sorting algorithm.
// Counting Sort Algorithm:
// Declare an auxiliary array countArray[] of size max(inputArray[])+1 and initialize it with 0.
// Traverse array inputArray[] and map each element of inputArray[] as an index of countArray[] array, i.e., execute countArray[inputArray[i]]++ for 0 <= i < N.
// Calculate the prefix sum at every index of array inputArray[].
// Create an array outputArray[] of size N.
// Traverse array inputArray[] from end and update outputArray[ countArray[ inputArray[i] ] - 1] = inputArray[i]. Also, update countArray[ inputArray[i] ] = countArray[ inputArray[i] ]- - .

public class TwentySix {
    public static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println("Maximum is:"+max);
        return max;
    }

    public static int[] countArr(int[] test, int[] count){
        for (int i = 0; i < test.length; i++) {
            count[test[i]] += 1; 
        }
        for (int i : count) {
            System.out.println(i);
        }
        return count;
    }

    public static int[] SortArrWithCount(int[] sortedArr, int[] count){
        int idx=0;
        for (int i = 0; i < count.length; i++) {
            for (int j=count[i]; j>0;j--) {
                sortedArr[idx++] = i;
            }
        }
        System.out.println("Sorted Array🥳");
        for (int k: sortedArr) {
            System.out.println(k+" ");
        }
        return sortedArr;
    }
    public static void main(String[] args) {
        int[] test = {2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9};
        int k = findMax(test);
        int[] count = new int[k+1];
        count = countArr(test, count);
        int[] sortedArr = new int[test.length];
        sortedArr = SortArrWithCount(sortedArr, count);
    }
}
