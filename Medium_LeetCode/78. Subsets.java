public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        List<Integer> cur = new ArrayList<>();
        helper(0, nums, cur, list);
        return list;
    }
    
    private void helper(int index, int[] nums,  List<Integer> cur, List<List<Integer>> list) {
        if (index == nums.length) {
            list.add(new ArrayList<Integer>(cur));
            return;
        }
        helper(index + 1, nums, cur, list);
        cur.add(nums[index]);
        helper(index + 1, nums, cur, list);
        cur.remove(cur.size() - 1);
    }
}