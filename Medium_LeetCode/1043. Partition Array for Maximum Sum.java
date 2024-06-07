class Solution {
    public int maxSumAfterPartitioning(int[] arr, int K) {
        int[] dp = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            int curMax = 0;
            for (int k = 1; k <= K && i - k >= 0; k++) {
                curMax = Math.max(curMax, arr[i - k]);
                dp[i] = Math.max(dp[i], dp[i - k] + curMax * k);
            }
        }
        return dp[arr.length];
    }
}