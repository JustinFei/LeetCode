// ---- DFS ----------------------------

class Solution {
    private final int[] dir = new int[]{-1, 0, 1};
    public int maxMoves(int[][] grid) {
        int[] res = new int[1];
        Deque<Integer> dq = new LinkedList<>();
        boolean[][] v = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            dq.offerLast(grid[r][0]);
            dfs(r, 1, res, grid, dq, v);
            dq.pollLast();
        }

        return res[0];
    }

    private void dfs(int r, int c, int[] res, int[][] grid, Deque<Integer> dq, boolean[][] v) {
        if (c == grid[0].length) return;
        for (int d : dir) {
            int row = r + d;
            if (row >= 0 && row < grid.length && !v[row][c] && grid[row][c] > dq.peekLast()) {
                dq.offerLast(grid[row][c]);
                v[row][c] = true;
                res[0] = Math.max(res[0], dq.size() - 1);
                dfs(row, c + 1, res, grid, dq, v);
                dq.pollLast();
            }
        }
    }
}

// ------------------------------------

class Solution {

    // The three possible directions for the next column.
    private final int[] dirs = { -1, 0, 1 };

    public int maxMoves(int[][] grid) {
        int M = grid.length, N = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[M][N];

        // Enqueue the cells in the first column.
        for (int i = 0; i < M; i++) {
            vis[i][0] = true;
            q.offer(new int[] { i, 0, 0 });
        }

        int maxMoves = 0;
        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int[] v = q.poll();

                // Current cell with the number of moves made so far.
                int row = v[0], col = v[1], count = v[2];

                maxMoves = Math.max(maxMoves, count);

                for (int dir : dirs) {
                    // Next cell after the move.
                    int newRow = row + dir, newCol = col + 1;

                    // If the next cell isn't visited yet and is greater than
                    // the current cell value, add it to the queue with the
                    // incremented move count.
                    if (
                        newRow >= 0 &&
                        newCol >= 0 &&
                        newRow < M &&
                        newCol < N &&
                        !vis[newRow][newCol] &&
                        grid[row][col] < grid[newRow][newCol]
                    ) {
                        vis[newRow][newCol] = true;
                        q.offer(new int[] { newRow, newCol, count + 1 });
                    }
                }
            }
        }

        return maxMoves;
    }
}

// ------------- Top-Down Dynamic Programming ---------------------

class Solution {

    // The three possible directions for the next column.
    private final int[] dirs = { -1, 0, 1 };

    private int DFS(int row, int col, int[][] grid, int[][] dp) {
        int M = grid.length, N = grid[0].length;

        // If we have calculated the moves required for this cell, return the answer and skip the recursion.
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int maxMoves = 0;
        for (int dir : dirs) {
            // Next cell after the move.
            int newRow = row + dir, newCol = col + 1;

            // If the next cell is valid and greater than the current cell value,
            // perform recursion to that cell with updated value of moves.
            if (
                newRow >= 0 &&
                newCol >= 0 &&
                newRow < M &&
                newCol < N &&
                grid[row][col] < grid[newRow][newCol]
            ) {
                maxMoves = Math.max(
                    maxMoves,
                    1 + DFS(newRow, newCol, grid, dp)
                );
            }
        }

        dp[row][col] = maxMoves;
        return maxMoves;
    }

    public int maxMoves(int[][] grid) {
        int M = grid.length, N = grid[0].length;

        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxMoves = 0;
        // Start DFS from each cell in the first column.
        for (int i = 0; i < M; i++) {
            int movesRequired = DFS(i, 0, grid, dp);
            maxMoves = Math.max(maxMoves, movesRequired);
        }

        return maxMoves;
    }
}

// ------------------- Bottom-up Dynamic Programming ----------------

class Solution {

    public int maxMoves(int[][] grid) {
        int M = grid.length, N = grid[0].length;

        int[][] dp = new int[M][N];
        // Cells in the first column will have the moves as 1.
        // This is required to ensure we have a way if the cell is reachable or not
        // from the first column.
        for (int i = 0; i < M; i++) {
            dp[i][0] = 1;
        }

        int maxMoves = 0;
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < M; i++) {
                // Check all the three next possible cells
                // Check if the next cell is greater than the previous one
                // Check if the previous cell was reachable,
                // if the value is > 0
                if (grid[i][j] > grid[i][j - 1] && dp[i][j - 1] > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }
                if (
                    i - 1 >= 0 &&
                    grid[i][j] > grid[i - 1][j - 1] &&
                    dp[i - 1][j - 1] > 0
                ) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                if (
                    i + 1 < M &&
                    grid[i][j] > grid[i + 1][j - 1] &&
                    dp[i + 1][j - 1] > 0
                ) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                }

                maxMoves = Math.max(maxMoves, dp[i][j] - 1);
            }
        }

        return maxMoves;
    }
}