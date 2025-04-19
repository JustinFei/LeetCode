class Solution {

    public long countFairPairs(int[] nums, int lower, int upper) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        return lower_bound(arr, upper + 1) - lower_bound(arr, lower);
    }

    // Calculate the number of pairs with sum less than `value`.
    private long lower_bound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // If sum is less than value, add the size of window to result and move to the
            // next index.
            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                // Otherwise, shift the right pointer backwards, until we get a valid window.
                right--;
            }
        }

        return result;
    }
}

// -------------------------------------------

class Solution {

    long lower_bound(int[] nums, int low, int high, int element) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] >= element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            // Assume we have picked nums[i] as the first pair element.

            // `low` indicates the number of possible pairs with sum < lower.
            long low = lower_bound(
                nums,
                i + 1,
                nums.length - 1,
                lower - nums[i]
            );

            // `high` indicates the number of possible pairs with sum <= upper.
            long high = lower_bound(
                nums,
                i + 1,
                nums.length - 1,
                upper - nums[i] + 1
            );

            // Their difference gives the number of elements with sum in the
            // given range.
            ans += 1 * (high - low);
        }
        return ans;
    }
}