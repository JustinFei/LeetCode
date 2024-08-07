class Solution {
        public int[][] restoreMatrix(int[] row, int[] col) {
        int m = row.length, n = col.length, i = 0, j = 0, a;
        int[][] res = new int[m][n];
        while (i < m && j < n) {
            a = res[i][j] = Math.min(row[i], col[j]);
            if ((row[i] -= a) == 0) i++;
            if ((col[j] -= a) == 0) j++;
        }
        return res;
    }
}