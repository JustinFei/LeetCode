class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) {
            return res;
        }
        helper(res, 0, n, 1);
        return res;
    }
    
    public void helper(int[][] res, int offset, int size, int num) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            res[offset][offset] = num;
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            res[offset][offset + i] = num++;
        }
        for (int i = 0; i < size - 1; i++) {
            res[offset + i][size + offset - 1] = num++;
        }
        for (int i = size - 1; i > 0; i--) {
            res[size + offset - 1][offset + i] = num++;
        }
        for (int i = size - 1; i > 0; i--) {
            res[offset + i][offset] = num++;
        }
        helper(res, offset + 1, size - 2, num);
    }
}

// -------------------------
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int row = 0;
        int col = 0;
        while (cnt <= n * n) {
            result[row][col] = cnt++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);

            // change direction if next cell is non zero
            if (result[r][c] != 0) d = (d + 1) % 4;

            row += dir[d][0];
            col += dir[d][1];
        }
        return result;
    }
}