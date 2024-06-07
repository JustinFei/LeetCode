
/*
    dp[k][i][j] means for first k crime with i members and at least j profit, what is total schemes can be chosen.
    And we need this Math.max(0, j - p), because this is for at least j profit.

    dp[k][i][j] = dp[k - 1][i][j] + dp[k - 1][i - current group][Math.max(0, j - current profit)]
*/

class Solution {
    private int mod = (int)1e9 + 7;
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][][] dp = new int[group.length + 1][G + 1][P + 1];
        dp[0][0][0] = 1;
        for (int k = 1; k <= group.length; k++) {
            int g = group[k - 1];
            int p = profit[k - 1];
            for (int i = 0; i <= G; i++) {
                for (int j = 0; j <= P; j++) {
                    dp[k][i][j] = dp[k - 1][i][j];
                    if (i >= g) {
                        dp[k][i][j] = (dp[k][i][j] + dp[k - 1][i - g][Math.max(0, j - p)])%mod;
                    }
                }
            }
        }
        int sum = 0;                                                       
        for(int i = 0; i <= G; i++){
            sum = (sum + dp[group.length][i][P])%mod;
        }
        return sum;
    }
}

//---------------
/*
    Because all k dimension only depends on k - 1 dimension, so we can improve it to 2D array which only has i and j dimension.
    Just be careful about that i and j should be decrease, in order to get correct old k - 1 dimension value.
*/

class Solution {
    private int mod = (int)1e9 + 7;
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        for (int k = 1; k <= group.length; k++) {
            int g = group[k - 1];
            int p = profit[k - 1];
            for (int i = G; i >= g; i--) {
                for (int j = P; j >= 0; j--) {
                    dp[i][j] = (dp[i][j] + dp[i - g][Math.max(0, j - p)])%mod;
                }
            }
        }
        int sum = 0;                                                       
        for(int i = 0; i <= G; i++){
            sum = (sum + dp[i][P])%mod;
        }
        return sum;
    }
}