class Solution {
    private int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }

    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            // if nums[j] < k gcd can never be equal to k for this subarray
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < k || nums[j] % k != 0) break; 
                gcd = getGCD(gcd, nums[j]);
                res += gcd == k ? 1 : 0;
            }
        }
            
        return res;
    }
}