import java.util.ArrayList;
import java.util.List;

public class FindSum2 {
    static void Sum2Recur(int index, int[] arr, int sum, List<Integer> ds){
        if(index >= arr.length){
            return;
        }
        if(sum == 2){
            System.out.print("[");
            for (Integer integer : ds) {
                System.out.print(integer+" ");
            }
            System.out.println("]");
            return;
        }

        // take
        sum += arr[index];
        ds.add(index);
        Sum2Recur(index + 1, arr, sum, ds);

        // Dont take
        sum -= arr[index];
        ds.remove(ds.size()-1);
        Sum2Recur(index + 1, arr, sum, ds);

        
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        ArrayList<Integer> ds = new ArrayList<>();
        int sum = 0;
        Sum2Recur(0, arr, sum, ds);
    }
}
