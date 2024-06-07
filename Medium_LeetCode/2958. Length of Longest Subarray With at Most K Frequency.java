class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0, left = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > k) {
                left++;
                map.put(nums[left], map.get(nums[left]) - 1);
            }
            res = Math.max(res, right - left);
        }

        return res;
    }
}