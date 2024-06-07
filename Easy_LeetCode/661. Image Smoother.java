class Solution {
        public int[][] imageSmoother(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0][0];
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        int[][] moves = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = matrix[i][j];
                int count = 1;
                for (int[] move : moves) {
                    int r = i + move[0];
                    int c = j + move[1];
                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        count++;
                        sum += matrix[r][c];
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}