class Solution {
    public int findMin(int[] nums) {
       if (nums == null) return 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r] && nums[m] >= nums[l])
                l = m + 1;
            else r = m;
        }
        return nums[l];
    }
}