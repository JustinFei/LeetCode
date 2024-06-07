// TC - O(n * t), where n is the number of coins, and t - the target amount.
// SC - O(t).

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1; 
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1; // number ways of selecting for amount zero is 1
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j]; // exclude current coin
                if (j - coins[i - 1] >= 0) { // check if amount  >= to the current i`th coin
                    dp[i][j] += dp[i][j - coins[i - 1]]; // include current coin
                }
            }
        }
        return dp[coins.length][amount];
    }
}

//  Time Limit Exceeded
class Solution {
      public int change(int amount, int[] coins) {
        return change(amount, coins, 0);
    }
    
    private static int change(int amount, int[] coins, int i) {
      if (amount < 0) return 0; // if amount is negative by which means not valid - 0
      if (amount == 0) return 1; // we found exact change
      if (i == coins.length && amount > 0) return 0; // means coins over and n>0 so no solution
      return change(amount - coins[i], coins, i) + change(amount, coins, i + 1); // include + exclude
    }
}


//  Time Limit Exceeded
class Solution {
    public int change(int amount, int[] coins) {
        if (amount < 0) return 0; 
      if (amount == 0) return 1; 
      if (coins.length == 0 && amount > 0) return 0; 
        int[] res = new int[1];
        change(0, amount, res, coins);
        return res[0];
    }
    
    private void change(int index, int target, int[] res, int[] coins) {
        if (index == coins.length - 1) {
            if (target % coins[index] == 0) {
                res[0]++; 
            }
            return;
        }
        int n = target / coins[index];
        for (int i = 0; i <= n; i++) {
            change(index + 1, target - coins[index] * i, res, coins);
        }
    }
}