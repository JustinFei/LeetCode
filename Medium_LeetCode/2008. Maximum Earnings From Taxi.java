class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);

        long[] dp = new long[n + 1];
        int j = 0;

        for (int i = 1; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i]);
            while (j < rides.length && rides[j][0] == i) {
                dp[rides[j][1]] = Math.max(dp[rides[j][1]], dp[i] + rides[j][1] - rides[j][0] + rides[j][2]);
                j++;
            }
        }

        return dp[n];
    }
}