// 40. Combination Sum II
// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

// import java.util.ArrayList;
// import java.util.Arrays;
// public class CombinationSum2 {

//     static void RecurseCombinationSum(int[] arr, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result, int idx, int sum, int target){

//         if(sum == target){
//             result.add(new ArrayList<>(current) );
//             return;
//         }
//         if(sum > target){
//             return;
//         }

//         if(idx>=arr.length){
//             return;
//         }

//         // take
//         current.add(arr[idx]);
//         RecurseCombinationSum(arr, current, result, idx+1, sum+arr[idx], target);

//         // not take
//         current.remove(current.size()-1);
//         RecurseCombinationSum(arr, current, result, idx+1, sum, target);

//     }
//     public static void main(String[] args) {
//         int[] arr = {10,1,2,7,6,1,5};
//         Arrays.sort(arr);
//         ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//         int sum = 0;
//         int idx = 0;
//         int target = 8;
//         ArrayList<Integer> current = new ArrayList<>();
//         RecurseCombinationSum(arr, current, result, idx, sum, target);

//         for (int i = 0; i < result.size(); i++) {
//             for (int j = 0; j < result.get(i).size(); j++) {
//                 System.out.print(result.get(i).get(j));
//             }
//             System.err.println();
//         }
//     }
// }

// My code ⬆️


// Optimised 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2{
    static void backtrack(int[] arr, int start, int target, List<Integer> current, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i< arr.length; i++){

            if(i>start && arr[i] == arr[i-1]){
                continue;
            }

            if(arr[i] > target) break;

            current.add(arr[i]);
            backtrack(arr, i+1, target-arr[i], current, result);

            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, 0, 8, new ArrayList<>(), result); 

        System.out.println(result);
    }
}