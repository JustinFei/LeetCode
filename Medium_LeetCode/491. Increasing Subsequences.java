public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2) return res;
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void dfs(int[] nums, int offset, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() > 1) res.add(new ArrayList<Integer>(cur));
        Set<Integer> set = new HashSet<>();
        for (int i = offset; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            if (cur.isEmpty() || nums[i] >= cur.get(cur.size() - 1)) {
                set.add(nums[i]);
                cur.add(nums[i]);
                dfs(nums, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}