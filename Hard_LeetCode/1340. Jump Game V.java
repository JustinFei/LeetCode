class Solution {
    public int maxJumps(int[] arr, int d) {
        int res = 0;
        
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, dfs(i, arr, d, dp));
        }
        return res;
    }
    
    private int dfs(int i, int[] arr,int d, int[] dp) {
        if (dp[i] != 0) {
            return dp[i];
        }
        dp[i] = 1;
        for (int j = i + 1; j <= Math.min(i + d, arr.length - 1) && arr[j] < arr[i]; j++)
            dp[i] = Math.max(dp[i], 1 + dfs(j, arr, d, dp));
        for (int j = i - 1; j >= Math.max(0, i - d) && arr[j] < arr[i]; j--)
            dp[i] = Math.max(dp[i], 1 + dfs(j, arr, d, dp));
        return dp[i];
    }
}