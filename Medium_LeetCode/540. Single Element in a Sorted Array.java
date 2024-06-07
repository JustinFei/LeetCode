class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int l = 0;
        int h = n / 2;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m * 2] != nums[m * 2 + 1]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l * 2];
    }
}