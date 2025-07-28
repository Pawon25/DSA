// Given three sorted arrays in non-decreasing order, print all common elements in non-decreasing order across these arrays. If there are no such elements return an empty array. In this case, the output will be -1.
// Note: In case of duplicate common elements, print only once.

// Examples: 
// Input: arr1[] = [1, 5, 10, 20, 30], arr2[] = [5, 13, 15, 20], arr3[] = [5, 20] 
// Output: 5 20
// Explanation: 5 and 20 are common in all the arrays.

// Input: arr1[] = [2, 5, 10, 30], arr2[] = [5, 20, 34], arr3[] = [5, 13, 19]
// Output: 5
// Explanation: 5 is common in all the arrays.

public class TwentySeven {
    public static void main(String[] args) {
        int[] arr1 = {1,5,10,20,30};
        int[] arr2 = {5,13,15,20};
        int[] arr3 = {5,20};
        int commonArrLen = Math.min(arr1.length, Math.min(arr2.length, arr3.length));
        System.out.println(commonArrLen);
        int[] cmnArr = new int[commonArrLen];

        int cmnIdx = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                for (int j2 = 0; j2 < arr3.length; j2++) {
                    if(arr1[i] == arr2[j] && (arr1[i] == arr3[j2])){
                        cmnArr[cmnIdx++] = arr1[i];
                    }
                }
            }
        }
        System.out.println("Comman Elements:");
        for (int i : cmnArr) {
            System.out.println(i+" ");
        }

    }
}

// This approch is stupid. We have already have sorted arr, and not taking advantage of it
// Can simply use SET or while(checking number before iterating arr further for an element; if searching for b and arr2 idx is already gt 2 then there is no reason to loop it further) 