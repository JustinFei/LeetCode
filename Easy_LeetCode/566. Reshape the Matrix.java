public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int m = nums[0].length;
        if (n * m != r * c) return nums;
        int row = 0; 
        int col = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                res[row][col] = nums[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        return res;
    }
}