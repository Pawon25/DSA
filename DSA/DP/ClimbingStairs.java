// You are climbing a staircase with n steps. Each move you can climb 1 or 2 steps.
// Count the number of DISTINCT sequences of moves that reach the top (step n).
// Order matters here: [1,2] and [2,1] are different ways.
//
// Example:
// Input: n = 4
// Output: 5
// Explanation: [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2]
//
// 5-step DP recipe:
// 1. State: dp[i] = number of distinct ways to reach step i.
// 2. Base case: dp[0] = 1 (one way to be at the start: take zero moves -
//    the empty move sequence still counts as ONE way, not zero).
//    dp[1] = 1 (only one move: a single 1-step).
// 3. Recurrence: dp[i] = dp[i-1] + dp[i-2] (last move was a 1-step from i-1,
//    or a 2-step from i-2).
// 4. Order: bottom-up, fill dp[2..n].
// 5. Answer: dp[n].

public class ClimbingStairs {

    // Approach 1 (first attempt): naive top-down recursion, no memoization.
    // Correct recurrence/base case, verified countWays(4) == 5.
    // Problem: overlapping subproblems get recomputed from scratch every time
    // (e.g. countWaysNaive(2) gets called separately by both countWaysNaive(4)
    // and countWaysNaive(3)) -> exponential time for large n. This is what
    // "dynamic programming" is actually solving: store results instead of
    // recomputing them.
    public static int countWaysNaive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return countWaysNaive(n - 1) + countWaysNaive(n - 2);
    }

    // Approach 2 (final): bottom-up tabulation. O(n) time, no recomputation.
    // Two off-by-one bugs found and fixed while building this:
    //   - array size: needed new int[n + 1] (indices 0..n), not new int[n],
    //     since the final read is dp[n].
    //   - loop bound: needed i <= n (i.e. i < n + 1), not i < n - 1, otherwise
    //     the last index(es) of dp[] never get filled before being read.
    public static int countWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Naive: " + countWaysNaive(n)); // expect 5
        System.out.println("Tabulation: " + countWays(n)); // expect 5
    }
}
