public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         if (nums == null || nums.length == 0) return res;
        
         permuteUnique(nums, 0, res);
         return res;
    }
    
    private void permuteUnique(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, i, index);
                permuteUnique(nums, index + 1, res);
                swap(nums, i, index);
            }
        }
    }
    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}