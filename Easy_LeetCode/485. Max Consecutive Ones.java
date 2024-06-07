public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
          if (nums[i] == 1) {
                if (i == 0 || nums[i - 1] == 0) {
                cur = 1;
               
            } else {
                cur++;
               
            }
              max = Math.max(cur, max);
          }
        }
        return max;
    }
}