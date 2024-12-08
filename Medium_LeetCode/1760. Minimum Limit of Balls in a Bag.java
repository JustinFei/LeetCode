class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, mid, right = 0, count; // right = 1_000_000_000;
        for (int num : nums) right = Math.max(right, num);
        while (left < right) {
            mid = left + (right - left) / 2;
            count = 0;
            for (int num : nums) count += (num - 1) / mid;
            
            if (count > maxOperations) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}