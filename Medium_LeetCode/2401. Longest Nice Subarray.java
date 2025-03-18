class Solution {
    public int longestNiceSubarray(int[] nums) {
        int used = 0, l = 0, res = 0;
        for (int r = 0; r < nums.length; r++) {
            while ((used & nums[r]) != 0) {
                used ^= nums[l++];
            }
            used |= nums[r];
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}