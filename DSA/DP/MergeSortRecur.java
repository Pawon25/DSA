import java.util.Arrays;
public class MergeSortRecur {
    static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }
    static int[] mergeSort(int[] arr){
        if(arr == null) {
            throw new IllegalArgumentException("Array should not be null");
        }
        if(arr.length <= 1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left,right);
    }
    

    public static void main(String[] args){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int[] sorted = mergeSort(arr);
        System.out.println(Arrays.toString(sorted));

    }
}
