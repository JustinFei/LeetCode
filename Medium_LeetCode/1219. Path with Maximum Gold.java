class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] visited = new boolean[m][n];
                    dfs(i, j, m, n, grid, visited, 0);
                }
            }
        }
        return max;
    }

    private void dfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited, int cur) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        cur += grid[i][j];
        max = Math.max(max, cur);
        for (int[] dir: dirs) {
            dfs(i + dir[0], j + dir[1], m, n, grid, visited, cur);
        }
        visited[i][j] = false;
    }
}

// --------------------------------------
class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int getMaximumGold(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        int[][] oneCellTrace = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0, goldCellId = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    oneCellTrace[i][j] = 1 << goldCellId++;
                    q.offer(new int[]{i, j, grid[i][j], oneCellTrace[i][j]});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1], sum = cur[2], trace = cur[3];
            ans = Math.max(sum, ans);
            for (int[] dir: dirs) {
                int r = i + dir[0], c = j + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] > 0 && (trace & oneCellTrace[r][c]) == 0) {
                    q.offer(new int[]{r, c, sum + grid[r][c], trace | oneCellTrace[r][c]});
                }
            }
        }
        return ans;
    }
}