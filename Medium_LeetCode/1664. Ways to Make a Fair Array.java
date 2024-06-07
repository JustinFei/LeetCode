class Solution {
    public int waysToMakeFair(int[] nums) {
        int res = 0, left[] = new int[2], right[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            right[i % 2] += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            right[i % 2] -= nums[i];
            if (left[0] + right[1] == left[1] + right[0])
                res++;
            left[i % 2] += nums[i];
        }

        return res;
    }
}