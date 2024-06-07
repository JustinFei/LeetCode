public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, cur, res);
        return res;
    }
    
    private void helper(int index, int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        cur.add(nums[index]);
        helper(index + 1, nums, cur, res);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) index++;
        cur.remove(cur.size() -1);
        helper(index + 1, nums, cur, res);
    }
}