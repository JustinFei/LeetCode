/*
    Explanation
    dp[i] means the result for n = i.

    if there is any k that dp[i - k * k] == false,
    it means we can make the other lose the game,
    so we can win the game an dp[i] = true.


    Complexity
    Time O(n^1.5)
    Space O(N)
*/

class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int k = 1; k * k <= i; ++k) {
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}