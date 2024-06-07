class Solution {
    public int uniquePathsIII(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int zero = 0, x = 0, y = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    zero++;
                } else if (grid[r][c] == 1) {
                    x = r;
                    y = c;
                }
            }
        }

        return path(zero, x, y, grid);
    }

    private int path(int zero, int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }

        if (grid[x][y] == 2) {
            return zero == -1 ? 1 : 0;
        }

        grid[x][y] = -1;
        zero--;

        int total = path(zero, x - 1, y, grid) + path(zero, x, y - 1, grid) + path(zero, x + 1, y, grid) + path(zero, x, y + 1, grid);
        grid[x][y]  = 0;

        // zero++;

        return total;
    }
}