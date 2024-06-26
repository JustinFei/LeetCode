class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        if(target > f * d) return 0;
        
        int modulo = (int) Math.pow(10, 9) + 7;
        
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        
        for(int i = 1; i <= d; i++){
            for(int j = 0; j <= target; j++){
                for(int k = 1; k <= f; k++){
                    //because [j-k] needs to be within the bounds of dp, that is, it needs to be greater than or equal to 0
                    if(j - k < 0) {
                        continue;
                    }  
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % modulo;
                }
            }
        }
        
        return dp[d][target];
    }
}