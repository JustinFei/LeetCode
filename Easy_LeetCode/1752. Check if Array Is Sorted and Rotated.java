class Solution {
    public boolean check(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        if (n == 1) return true;
        
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] <= nums[i]) continue;
            else if (flag) {
                flag = false;
                if (nums[0] < nums[n - 1]) return false;
            }
            else return false;
        }
        return true;
    }
}