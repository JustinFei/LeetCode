// DFS: O(n ^ 9)

class Solution {
    public int cherryPickup(int[][] grid) {
        return dfs(grid, 0, 0, grid[0].length - 1);
    }

    // r: current row
    // ac: Robot A cur Column
    // bc: Robot B cur Column
    private int dfs(int[][] grid, int r, int ac, int bc) {
        if (ac < 0 || ac >= grid[0].length || bc < 0 || bc >= grid[0].length) return 0;

        if (r == grid.length) return 0;

        int res = grid[r][ac] + grid[r][bc];

        int max = 0;
        for (int a = ac - 1; a <= ac + 1; a++) {
            for (int b = bc - 1; b <= bc + 1; b++) {
                if (a < b) {
                    max = Math.max(max, dfs(grid, r + 1, a, b));
                }
            }
        }

        return res += max; 
    }
}

// Memorization, Top Down DP: O(m*n^2) O(m*n^2)

class Solution {
    Integer memo[][][];

    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        memo = new Integer[r][c][c];
        return dfs(grid, 0, 0, c - 1);
    }

    // r: current row
    // ac: Robot A cur Column
    // bc: Robot B cur Column
    private int dfs(int[][] grid, int r, int ac, int bc) {
        if (ac < 0 || ac >= grid[0].length || bc < 0 || bc >= grid[0].length) return 0;

        if (r == grid.length) return 0;
        if (memo[r][ac][bc] != null) return memo[r][ac][bc];

        int res = grid[r][ac] + grid[r][bc];

        int max = 0;
        for (int a = ac - 1; a <= ac + 1; a++) {
            for (int b = bc - 1; b <= bc + 1; b++) {
                // for gathering max cherries, robots should cross
                if (a < b) {
                    max = Math.max(max, dfs(grid, r + 1, a, b));
                }
            }
        }
        return memo[r][ac][bc] = res + max; 
    }
}