class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int n: list) {
            res[i++] = n;
        }
        return res;
    }
}