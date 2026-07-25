// You are given an integer n (target amount) and coins {1, 2} in unlimited supply.
// Count the number of distinct COMBINATIONS (order doesn't matter) that sum to n.
// e.g. 1+1+2 and 2+1+1 count as ONE way, not two.
//
// Example:
// Input: n = 4
// Output: 3
// Explanation: ways are [1,1,1,1], [1,1,2], [2,2]

public class CoinChangeCombinations {
    public static int countWays(int n) {
        // TODO: implement
        int count = 0;

        // My logic is to have one coin as constant and to check if another coins mutiple can statisfy the target.
        for(int i=n; i>=0; i--){
            int onesValue = 1 * i;
            int target = n - onesValue;
            if(target%2 == 0){
                count++;
            }

            System.out.println(
                "onesValue = " + onesValue + "\n" +
                "target = " + target + "\n" +
                "target%2 = " + target%2 + "\n" +
                "count = " + count + "\n" 
            );
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n)); // expect 3
    }
}
