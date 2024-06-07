class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int res = 0, i = 0, n = nums.size();
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < n; j++) {
            count.put(nums.get(j), count.getOrDefault(nums.get(j), 0) + 1);
            res = Math.max(res, count.get(nums.get(j)));
            if (j - i - res >= k) {
                count.put(nums.get(i), count.get(nums.get(i)) - 1);
                i++;
            }
        }
        return res;
    }
}