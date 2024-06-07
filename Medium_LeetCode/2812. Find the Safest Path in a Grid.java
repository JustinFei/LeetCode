class Solution {
    private static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int min = 0;
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) return 0;

        int[][] score = new int[n][n];
        for (int[] row : score) Arrays.fill(row, Integer.MAX_VALUE);
        bfs(grid, score, n);

        boolean[][] v = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> -Integer.compare(a[2], b[2]));

        pq.offer(new int[]{0, 0, score[0][0]});
        v[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1];
            int s = cur[2];

            if (x == n - 1 && y == n - 1) return s;

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                // if (nx < 0 || nx >= n || ny < 0 || ny >= n || v[nx][ny]) continue;
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny]) {
                    int ns = Math.min(s, score[nx][ny]);
                    pq.offer(new int[]{nx, ny, ns});
                    v[nx][ny] = true;
                }
            }
        }

        return 0;
    }

    private void bfs(List<List<Integer>> grid, int[][] score, int n) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    score[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int x, y, cur[], s, nx, ny;
        while (!q.isEmpty()) {
            cur = q.poll();
            x = cur[0];
            y = cur[1];
            s = score[x][y];

            for (int[] dir : dirs) {
                nx = x + dir[0];
                ny = y + dir[1];

                // if (nx < 0 || nx >= n || ny < 0 || ny >= n || score[nx][ny] <= s + 1) continue;
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && score[nx][ny] > s + 1) {
                    score[nx][ny] = s + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}