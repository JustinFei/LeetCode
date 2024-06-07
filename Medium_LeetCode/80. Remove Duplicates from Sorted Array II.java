class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 3) return nums.length;
        int slow = 1;
        for (int i = 2 ; i < nums.length; i++) {
            if (nums[i] != nums[slow - 1]) {
                nums[++slow] = nums[i];
            }
        }
        return ++slow;
    }
}