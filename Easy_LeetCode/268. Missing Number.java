public class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] && nums[i] != nums.length) {
                swap(nums, nums[i], i);
            }
        }
        for(int i = 0 ; i < nums.length; i++) {
            if (i != nums[i])  return i;
        }
        return nums.length;
    }
    
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

// ----------------------------

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}