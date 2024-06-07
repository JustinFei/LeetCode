class Solution {
    public int longestArithSeqLength(int[] nums) {
        int res = 0, n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int r = 0; r < n; r++) {
            dp[r] = new HashMap<>();
            for (int l = 0; l < r; l++) {
                int diff = nums[r] - nums[l];
                dp[r].put(diff, dp[l].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[r].get(diff));
            }
        }
        return res;
    }
}