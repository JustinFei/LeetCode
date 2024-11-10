class Solution {

    public int minimumSubarrayLength(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int[] bitCounts = new int[32]; // Tracks count of set bits at each position

        // Expand window until end of array
        for (int end = 0; end < nums.length; end++){
            // Add current number to window
            updateBitCounts(bitCounts, nums[end], 1);

            // Contract window while OR value is valid
            while (
                start <= end &&
                convertBitCountsToNumber(bitCounts) >= k
            ) {
                // Update minimum length found so far
                minLength = Math.min(minLength, end - start + 1);

                // Remove leftmost number and shrink window
                updateBitCounts(bitCounts, nums[start], -1);
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    // Updates bit count array when adding/removing a number from window
    private void updateBitCounts(int[] bitCounts, int number, int delta) {
        for (int i = 0; i < 32; i++) {
            // Check if bit is set at current position
            if (((number >> i) & 1) != 0) {
                bitCounts[i] += delta;
            }
        }
    }

    // Converts bit count array back to number using OR operation
    private int convertBitCountsToNumber(int[] bitCounts) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCounts[i] != 0) {
                result |= 1 << i;
            }
        }
        return result;
    }
}