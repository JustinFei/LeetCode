class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res = 0, total = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            total += nums[r];
            while (total * (r - l + 1) >= k) {
                total -= nums[l++];
            }
            res += r - l + 1;
        }

        return res;
    }
}