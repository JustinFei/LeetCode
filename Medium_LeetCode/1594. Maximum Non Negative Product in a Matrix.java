class Solution {
    public int maxProductPath(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // int mod = 1_000_000_007;
        int mod = 1000000007;
        
        long[] minDp = new long[cols];
        long[] maxDp = new long[cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 && c == 0) {
                    minDp[c] = maxDp[c] = grid[r][c];
                    continue;
                }
                
                Long min = Long.MAX_VALUE;
                Long max = Long.MIN_VALUE;
                if (r > 0) {
                    min = Math.min(grid[r][c] * minDp[c], grid[r][c] * maxDp[c]);
                    max = Math.max(grid[r][c] * minDp[c], grid[r][c] * maxDp[c]);
                }
                if (c > 0) {
                    min = Math.min(Math.min(grid[r][c] * minDp[c - 1], grid[r][c] * maxDp[c - 1]), min);
                    max = Math.max(Math.max(grid[r][c] * minDp[c - 1], grid[r][c] * maxDp[c - 1]), max);
                }
                
                minDp[c] = min;
                maxDp[c] = max;
            }
        }
        
        return maxDp[cols - 1] >= 0 ? (int) (maxDp[cols - 1] % mod) : -1;
    }
}