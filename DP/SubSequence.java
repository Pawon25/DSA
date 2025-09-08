// Subsequence: a contigeous or non contigeous sequences which follows the order
// [3,2,1] => {}, {3}, {2}, {1}, {3,2}, {3,1}, {2,1}, {3,2,1}

// Take or not take method

import java.util.ArrayList;

public class SubSequence {
    static void printSubsequence(int[] arr, ArrayList<Integer> ds, int index){
        if(index == arr.length){
            if(ds.size() == 0){
                System.out.println("{}");
            } else {
                for (int num : ds) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            return;
        }

        // take the index and move
        ds.add(arr[index]);
        printSubsequence(arr, ds, index+1);

        // not take the index
        ds.remove(ds.size()-1);
        printSubsequence(arr, ds, index+1);
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        ArrayList<Integer> ds = new ArrayList<>();
        int index = 0;
        printSubsequence(arr, ds, index);
    }
}
