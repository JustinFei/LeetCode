class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        // minPosition, maxPosition: the MOST RECENT positions of minK and maxK.
        // leftBound: the MOST RECENT value outside the range [minK, maxK].
        long res = 0, jbad = -1, jmin = -1, jmax = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            // If the number is outside the range [minK, maxK], update the most recent leftBound.
            if (nums[i] < minK || nums[i] > maxK) jbad = i;

            // If the number is minK or maxK, update the most recent position.
            if (nums[i] == minK) jmin = i;
            if (nums[i] == maxK) jmax = i;

            // The number of valid subarrays equals the number of elements between leftBound and 
            // the smaller of the two most recent positions (minPosition and maxPosition).
            res += Math.max(0L, Math.min(jmin, jmax) - jbad);
        }
        return res;
    }
}