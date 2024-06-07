class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            for (int end = start; end < n; end++) {
                String cur = s.substring(start, end + 1);
                if (set.contains(cur)) {
                    dp[start] = Math.min(dp[end + 1], dp[start]);
                }
            }
        }

        return dp[0];
    }
}