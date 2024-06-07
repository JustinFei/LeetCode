public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        permute(nums, 0, res);
        return res;
    }
    private void permute(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permute(nums, index + 1, res);
            swap(nums, i, index);
        }
    }
    
    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}