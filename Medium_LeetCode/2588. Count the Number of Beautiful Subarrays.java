class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        int pre = 0;
        long res = 0;
        for (int num : nums) {
            pre ^= num;
            int v = dp.getOrDefault(pre, 0);
            res += v;
            dp.put(pre, v + 1);
        }

        return res;
    }
}