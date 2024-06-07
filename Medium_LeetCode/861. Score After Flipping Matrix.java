class Solution {
    public int matrixScore(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int res = (1 << (c  - 1)) * r;

        for (int j = 1; j < c; j++) {
            int cur = 0;
            for (int i = 0; i < r; i++) {
                cur += grid[i][j] == grid[i][0] ? 1 : 0;
            }
            res += Math.max(cur, r - cur) * (1 << (c - j - 1));
        }

        return res;
    }
}