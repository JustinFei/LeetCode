class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }
    
    private int rob(int[] nums, int start, int end) {
        int pre1 = 0, pre2 = 0, max = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = max;
        }
        return max;
    }
}