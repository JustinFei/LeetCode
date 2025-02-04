class Solution {
    public int maxAscendingSum(int[] nums) {
        int tmp = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) tmp += nums[i];
            else tmp = nums[i];

            max = Math.max(tmp, max);
        }
        return max;
    }
}