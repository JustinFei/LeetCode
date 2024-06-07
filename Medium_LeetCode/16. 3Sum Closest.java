class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        int sum, left, right;
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length -1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}