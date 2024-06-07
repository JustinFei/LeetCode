class Solution {
    public int longestSubarray(int[] nums) {
        int s = 0, f, zero = 1, res = 0;
        for (f = 0; f < nums.length; f++) {
            zero -= nums[f] == 0 ? 1 : 0;

            while (zero < 0) {
                zero += nums[s] == 0 ? 1 : 0;
                s++;
            }
            res = Math.max(res, f - s);           
        }
        return res;
    }
}