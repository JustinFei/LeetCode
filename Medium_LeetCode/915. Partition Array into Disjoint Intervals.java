class Solution {
    public int partitionDisjoint(int[] nums) {
        int curMax = nums[0], partitionIdx = 0, max = curMax;
        for (int i = 1; i < nums.length; i++)
            if (curMax > nums[i]) {
                curMax = max;
                partitionIdx = i;
            } else {
                max = Math.max(max, nums[i]);
            }
        return partitionIdx + 1;
    }
}