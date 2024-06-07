class Solution {
    public int maxCoins(int[] nums) {
        int[] array = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) array[n++] = x;
        array[0] = array[n++] = 1;
        // n == nums.length + 2

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right], 
                    array[left] * array[i] * array[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}