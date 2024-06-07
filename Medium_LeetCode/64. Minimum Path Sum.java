public class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                     matrix[i][j] = grid[i][j];
                } else if (i == 0) {
                    matrix[i][j] = matrix[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    matrix[i][j] = matrix[i - 1][j] + grid[i][j];
                } else {
                    matrix[i][j] = Math.min(matrix[i -1][j], matrix[i][j - 1]) + grid[i][j];
                }
            }
        }
        return matrix[m -1][n - 1];
    }
}