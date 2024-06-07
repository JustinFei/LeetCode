class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] stack = new int[k];
        int j = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            while (j > 0 && stack[j - 1] > nums[i] && j - 1 + n - i >= k) {
                j--;
            }
            if (j < k) {
                stack[j++] = nums[i];
            }
        }
        return stack;
    }
}