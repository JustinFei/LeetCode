class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long preSum = 0;
        long ans = - 1;
        for (int num : nums) {
            if (num < preSum) {
                ans = num + preSum;
            }
            preSum += num;
        }
        return ans;
    }
}