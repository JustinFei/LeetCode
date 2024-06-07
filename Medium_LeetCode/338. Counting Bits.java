public class Solution {
    public int[] countBits(int num) {
        int[] nums = new int[num + 1];
        
        for(int i = 0; i <= num; i++){
             nums[i] = nums[i>>>1] + (i & 1);
        }
       return nums;
    }
    
}