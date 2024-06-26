public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0 || nums.length == 0) return 0;
        int i = 0; 
        int j = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}