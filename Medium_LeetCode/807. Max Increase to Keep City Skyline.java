class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMaxes = new int[n];
        int[] colMaxes = new int[n];

        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++) {
                rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c]);
                colMaxes[c] = Math.max(colMaxes[c], grid[r][c]);
        }

        int res = 0;
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                res += Math.max(Math.min(rowMaxes[r], colMaxes[c]) - grid[r][c], 0);

        return res;
    }
}