class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int third = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            }
            while (!stack.isEmpty() && stack.peekFirst() < nums[i]) {
                third = stack.pollFirst();
            }
            stack.offerFirst(nums[i]);
        }
        return false;
    }
}