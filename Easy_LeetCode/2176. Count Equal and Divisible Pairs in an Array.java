class Solution {
    public int countPairs(int[] nums, int k) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    res++;
                }
            }
        }

        return res;
    }
}

// ----------------------------------------------

class Solution {
    public int countPairs(int[] nums, int k) {
        int res = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        for (List<Integer> indices : map.values()) {
            for (int i = 0; i < indices.size() - 1; i++) {
                for (int j = i + 1; j < indices.size(); j++) {
                    if (((long) indices.get(i) * indices.get(j)) % k == 0) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}