public class ReverseArray {
    public static int[] arr = {1, 2, 3, 4, 5, 6};
    public static void Swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static int[] RecurseReverse(int[] arr, int l, int j){
        if(l>=j){
            System.out.println("Recursion Completed");
            return arr;
        }
        Swap(arr, l, j);
        return RecurseReverse(arr, l+1, j-1);
    }

    public static void main(String[] args) {
        RecurseReverse(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
