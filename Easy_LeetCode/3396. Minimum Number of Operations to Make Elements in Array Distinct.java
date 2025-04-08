class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = nums.length - 1;
        while (i >= 0) {
            if (!set.add(nums[i])) break;
            i--;
        }
        if (i == -1) return 0;
        i++;
        return i / 3 + (i % 3 != 0 ? 1 : 0);
    }
}