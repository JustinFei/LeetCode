class Solution {
    public int matrixSum(int[][] nums) {
        for (int[] row : nums) {
            Arrays.sort(row);
        }
        int res = 0;
        int curMax;
        for (int c = 0; c < nums[0].length; c++) {
            curMax = 0;
            for (int r = 0; r < nums.length; r++) {
                curMax = Math.max(nums[r][c], curMax);
            }
            res += curMax;
        }

        return res;
    }
}