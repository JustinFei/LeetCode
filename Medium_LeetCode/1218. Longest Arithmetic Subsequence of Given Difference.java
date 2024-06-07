class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int a: arr) {
            int b = map.getOrDefault(a - difference, 0);
            map.put(a, b + 1);
            res = Math.max(res, map.get(a));
        }
        
        return res;
    }
}