class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++) {
                long diff = Math.abs((long)nums[i] - (long)nums[j]);
                if (diff <= t)
                    return true;
            }
        }
        return false;
    }
}