class Solution {
    public boolean stoneGame(int[] p) {
        // return true;
        int n = p.length;
        int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = p[i];
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
        return dp[0][n - 1] > 0;
    }
}

//------------------------
class Solution {
    int[][] cache;
    int[] sums;
    public boolean stoneGame(int[] piles) {
        sums = new int[piles.length];
        sums[0] = piles[0];
        for(int i = 1; i < piles.length; i ++)
            sums[i] = sums[i-1] + piles[i];
        
        cache = new int[piles.length][ piles.length];
        
        int alexGain = helper(piles, 0, piles.length - 1);
        return alexGain > sums[piles.length - 1] - alexGain;
    }
    
    public int helper(int[] piles, int start, int end){
        if(start > end)
            return 0;
        if(cache[start][end] != 0)
            return cache[start][end];
        
        int sum = sums[end] - sums[start] + piles[start];
        // minimize the gain of next player
        cache[start][end] = sum - 
            Math.min(helper(piles, start + 1, end), helper(piles, start, end - 1));
        
        return cache[start][end];
    }
}