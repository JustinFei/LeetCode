public class Solution {
    public int jump(int[] nums) {
        int min = 0;
        int edge = 0;
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if( i == edge ) {
                min++;
                edge = max;
                if (edge > nums.length - 1) break;
            } 
        }
        return min;
    }   
}