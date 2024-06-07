class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 1;
        int tmp = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                tmp++;
                res = Math.max(tmp, res);
            } else {
                tmp = 1;
            }
        }
        return res;
    }
}