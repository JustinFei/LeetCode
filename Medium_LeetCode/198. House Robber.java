class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        return dp[nums.length];
    }
}

// -------------------------------------------

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        int tmp, pre = 0, res = 0;
        
        for (int num : nums) {
            tmp = res;
            res = Math.max(res, num + pre);
            pre = tmp;
        }

        return res;
    }
}