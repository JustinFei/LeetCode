class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i == k - 1)  {
                max = sum;
            }
            if (i >= k) {
                sum -= nums[i - k];
                if (max < sum) {
                     max = sum;
                }
            }

        }
        return max / k;
    }
}