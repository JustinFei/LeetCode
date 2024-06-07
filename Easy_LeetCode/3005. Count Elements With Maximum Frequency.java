class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int max = 0, res = 0;

        for (Integer v : map.values()) {
            if (v > max) {
                max = v;
                res = v;
            } else if (v == max) {
                res += v;
            }
        }

        return res;
    }
}