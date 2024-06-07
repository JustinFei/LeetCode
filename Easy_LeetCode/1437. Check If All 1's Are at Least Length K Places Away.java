class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int c = 0, i = 0;
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
        for (i = i + 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (c < k) {
                    return false;
                }
                c = 0;
            } else {
                c++;
            }
        }
        
        return true;
    }
}