class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int r = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    res[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (matrix[i][j] == '1') {
                    res[i][j] = Math.min(res[i - 1][j]  + 1, res[i][j - 1] + 1);
                    res[i][j] = Math.min(res[i][j], res[i - 1][j - 1] + 1);
                }
                r = Math.max(r, res[i][j]);
            }
        }
        return r * r;
    }
}