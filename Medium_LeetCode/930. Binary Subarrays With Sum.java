class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0, pSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pSum += num;
            res += map.getOrDefault(pSum - goal, 0);
            map.merge(pSum, 1, Integer::sum);
        }
        return res;
    }
}