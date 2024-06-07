class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) continue;
            
            // 1.Find left and right num
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int sum = left + right + 1;
            res = Math.max(res, sum);
            
            // 2.Union by only updating boundary
            // Leave middle k-v dirty to avoid cascading update
            if (left > 0) map.put(num - left, sum);
            if (right > 0) map.put(num + right, sum);
            map.put(num, sum); // Keep each number in Map to de-duplicate
        }
        return res;
    }
}