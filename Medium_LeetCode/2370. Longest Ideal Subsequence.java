class Solution {
    public int longestIdealString(String s, int k) {
        int res = 0, n = s.length();
        int[] dp = new int[26];
        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'a';
            int best = 0;
            for (int prev = 0; prev < 26; prev++)
                if (Math.abs(prev - cur) <= k)
                    best = Math.max(best, dp[prev]);
            
            dp[cur] = Math.max(dp[cur], best + 1);
            res = Math.max(res, dp[cur]);
        }

        return res;
    }
}