public class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) return i;
        }
        return nums.length;
    }
}

//---------------------------
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1, mid;
        while (left < right - 1) {
          mid = left + (right - left) / 2;
          if (nums[mid] == target) {
            return mid;
          } else if (nums[mid] < target) {
            left = mid;
          } else {
            right = mid;
          }

        }
        if (nums[left] >= target) {
            return left;
        } else if (nums[right] >= target) {
            return right;
        }
        return right + 1;
    }
}