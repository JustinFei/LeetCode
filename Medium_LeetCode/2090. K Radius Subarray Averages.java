class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) return nums;
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (n < k * 2 + 1) return res;
        long tmp = 0;
        for (int i = 0; i < k * 2; i++) {
            tmp += nums[i];
        }

        for (int i = k; i < n - k; i++) {
            tmp += nums[i + k];
            res[i] = (int) (tmp / (k * 2 + 1));
            tmp -= nums[i - k];
        }

        return res;
    }
}