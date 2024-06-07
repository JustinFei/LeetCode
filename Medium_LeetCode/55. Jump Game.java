public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        } else if (nums[0] == 0){
            return false;
        }
        
        boolean[] canJ = new boolean[nums.length];
        canJ[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i -1; j >= 0; j--) {
                if (canJ[j] && j + nums[j] >= i) {
                    canJ[i] = true;
                    break;
                }
            }
        }
        return canJ[nums.length - 1];
        
    }
}