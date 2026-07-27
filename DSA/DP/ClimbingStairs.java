// You are climbing a staircase with n steps. Each move you can climb 1 or 2 steps.
// Count the number of DISTINCT sequences of moves that reach the top (step n).
// Order matters here: [1,2] and [2,1] are different ways.
//
// Example:
// Input: n = 4
// Output: 5
// Explanation: [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2]

public class ClimbingStairs {
    public static int countWays(int n) {
        // TODO: implement using the 5-step DP recipe:
        // 1. State: dp[i] = ?
        // 2. Base case(s): dp[0] = ?, dp[1] = ?
        // 3. Recurrence: dp[i] = ?
        // 4. Order: bottom-up, fill dp[2..n]
        // 5. Answer: dp[n]

        // I think we need to create an array to store the counts, lets say dp[0] = 1, dp[1]=1, dp[2]=2(11,2), dp[3]=3(111,12,21)
        // for base case i think we need to do, dp[0]=1, dp[1]=1
        // and for dp[i] we need to do dp[i-1], dp[i-2]

        // we need to recurse from 2 to n. we can keep on passing updated varibale till that variable exceed n

        if(n == 0 || n == 1){
            return 1;
        }

        if(n>0){
            return countWays(n-1) + countWays(n-2);
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n)); // expect 5
    }
}
