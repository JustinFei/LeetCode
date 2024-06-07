class Solution {
    int[][] grid;
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int res = 0;
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res = Math.max(res, helper(i, j));
            }
        }
        return res;
    }
    
    private int helper(int i, int j) {
        int r = grid.length;
        int c = grid[0].length;
        if (i < 0 || i > r - 1 || j < 0 || j > c - 1 || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + helper(i - 1, j) + helper(i, j - 1) + helper(i + 1, j) + helper(i, j + 1);
    }
}