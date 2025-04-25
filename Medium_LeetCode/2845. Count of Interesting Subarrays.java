class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long res = 0;
        int acc = 0;
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 1)); //  map.put(0, 1);
        for (int a : nums) {
            acc = (acc + (a % modulo == k ? 1 : 0)) % modulo;
            res += map.getOrDefault((acc - k + modulo) % modulo, 0);
            map.put(acc, map.getOrDefault(acc, 0) + 1);
        }
        return res;
    }
}