// Quick sort is an sorting algorithem which has same time complexity as merge sort but doesnt use extra space.
//  space complexity: O(log n)
//  time complexity: O(nlogn)


// Choose an pivot element and place it is the correct index.
// How? put in a position where all elements in the left is less than pivot element and all in the right is greater than it.
// then consider lesser arr as left and greater array as right which will be seperated unsorted arrays.
// repeat from choosing pivot element.

public class QuickSortRecursion {

    static int getPivotIdx(int[]arr,int left,int right){
        int pivot = arr[left];
        int i = left+1;
        int j = right;

        while(i<=j){
            while (i<=right && arr[i] <= pivot) {
                i++;
            }
            while (j >=left && arr[j]> pivot) {
                j--;
            }
            if(i<j){
                swap(arr, i, j);
            }
        }
        swap(arr, left, j);
        return j;
    }
    static void swap(int[] arr, int pivotindex, int left){
        int var = arr[pivotindex];
        arr[pivotindex] = arr[left];
        arr[left] = var;

        
    }

    static int[] QuickSort(int[] arr, int left, int right){
        if(left >= right){
            return arr;
        }
        int pivotelement = arr[left];
        System.out.println("PivotElemt=="+pivotelement);
        int pivotindex = getPivotIdx(arr, left, right);
        System.out.println("PivotIdex=="+pivotindex);
        QuickSort(arr, left, pivotindex-1);
        QuickSort(arr, pivotindex+1, right);

        return arr;
    }
    
    public static void main(String[] args) {
        int[] arr = {9,8,7};
        int[] sortedarr = new int[arr.length];
        try{
            sortedarr = QuickSort(arr, 0, arr.length-1);
        }catch(StackOverflowError e){
            System.out.println("Stack overflow error is comming");
        }
        System.out.println("====================================");
        for (int i = 0; i < sortedarr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("====================================");

    }
}


