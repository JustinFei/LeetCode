public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null) return 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            long tmp = 0;
            for (int j = i; j < nums.length; j++) {
                tmp += nums[j];
                if (tmp == (long) k) cnt++;
            }
        }
        return cnt;
    }
}

// --------------------------
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        long tmp = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put((long) 0, 1);
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            if (map.containsKey(tmp - k)) {
                res += map.get(tmp - k);
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        return res;
    }
}