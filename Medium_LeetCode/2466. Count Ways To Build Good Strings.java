class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long mod = (long)1e9 + 7, res = 0;
        long[] dp = new long[high + 1];
        dp[0] = 1;
        int s = Math.min(zero, one);
        for (int i = 1; i <= high; i++) {
            if (i >= zero) dp[i] += dp[i - zero];
            if (i >= one) dp[i] += dp[i - one];
            dp[i] %= mod;
            if (i >= low) res += dp[i];
            res %= mod;

            // dp[i]=((i - zero >= 0 ? dp[i-zero] : 0) + (i - one >=0 ? dp[i-one] : 0)) % mod;
            // if(i>=low){
            //     res=(res + dp[i]) % mod;
            // }
        }

        return (int) res;
    }
}