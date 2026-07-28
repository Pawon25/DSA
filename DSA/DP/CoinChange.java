// You are given coins of different denominations (unlimited supply of each)
// and a total amount n. Return the FEWEST number of coins needed to make up
// that amount. If it's not possible with any combination, return -1.
//
// Example:
// Input: coins = [1, 2, 5], n = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

// 5-step DP recipe:
// 1. State:
// 2. Base case:
// 3. Recurrence:
// 4. Order:
// 5. Answer:

public class CoinChange {

    public static int minCoins(int[] coins, int n) {
        // TODO

        // 1. dp[i] is the number that shows the number of coins we need make n
        // 2. base case is if n == coins[j] we need to return 1, 
        // 3. Also once we reach the req target is less than smallest coin in the array then we can break and say that combination doesnt work ou
        // 4. once we get n = coint[i] + coin[j] .... we can increase count

        // Ok I dont know what i am doing

        int[] dp = new int[n+1];
        for(int i = 1; i<=n; i++){
            dp[i] = i+1;
        }
        dp[0] = 0;

        for(int i = 1; i<=n; i++){
            for(int c:coins){
                if(c<=i){
                dp[i] = Integer.min(dp[i], dp[i-c]+1);   //I really doesnt understand this
                }
            }
        }

        if(n<dp[n]){
            return -1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int n = 11;
        System.out.println(minCoins(coins, n)); // expect 3
    }
}
