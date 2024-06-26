class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 2);
        dp[0] = 0;
        for (int i = 0; i <= n; i++)
            for (int j = Math.max(i - ranges[i] + 1, 0); j <= Math.min(i + ranges[i], n); j++)
                dp[j] = Math.min(dp[j], dp[Math.max(0, i - ranges[i])] + 1);
        return dp[n] == n + 2 ? -1 : dp[n];
    }
}