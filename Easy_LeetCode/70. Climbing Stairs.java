
// Time Limit Exceeded
class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

// ------------------------------------

class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

// -------------------------------------

class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;

        int temp, pre = 1, cur = 1;
        for (int i = 2; i <= n; i++) {
            temp = cur;
            cur += pre;
            pre = temp;
        }

        return cur;
    }
}