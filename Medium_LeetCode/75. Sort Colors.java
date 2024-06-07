public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = nums.length - 1;
        while (one <= two) {
            if (nums[one] == 0) {
                swap(nums, one++, zero++);
            } else if (nums[one] == 2) {
                swap(nums, one, two--);
            } else one++;
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}