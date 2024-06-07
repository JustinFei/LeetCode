public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        int[] res = { 0 };
        
        helper(0, 0, res, nums, S);
        return res[0];
    }
    
    private void helper(int index, int tmp, int[] res, int[] nums, int target) {
        if (index == nums.length) {
            if (tmp == target) res[0]++;
            return;
        }
        helper(index + 1, tmp + nums[index], res, nums, target);
        helper(index + 1, tmp - nums[index], res, nums, target);
    }
}