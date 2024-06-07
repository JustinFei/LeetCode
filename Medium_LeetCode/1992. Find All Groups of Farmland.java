class Solution {
    // The four directions in which traversal will be done.
    int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    // Global variables with 0 value initially.
    int nx, ny;
    
    private void dfs(int[][] land, boolean[][] v, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n || v[x][y] || land[x][y] == 0) return;
        v[x][y] = true;
        // Maximum x and y for the bottom right cell.
        nx = Math.max(nx, x); ny = Math.max(ny, y);
        
        for (int[] dir : dirs) dfs(land, v, x + dir[0], y + dir[1], m, n);
    }
    
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        boolean[][] v = new boolean[m][n];
        List<int[]> ans = new ArrayList<>();
        

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (land[x][y] == 1 && !v[x][y]) {
                    nx = 0; ny = 0;
                    dfs(land, v, x, y, m, n);
                    int[] arr = new int[] {x, y, nx, ny};
                    ans.add(arr);
                }
            }
        }
        
        return ans.stream().toArray(int[][] :: new);
    }
}

// ----------------------------

class Solution {
    // The four directions in which traversal will be done.
    int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    // Returns true if the coordinate is within the boundary of the matrix.
    private boolean isWithinFarm(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private Pair<Integer, Integer> bfs(Queue<Pair<Integer, Integer>> q, int[][] land,
        boolean[][] v) {
        Pair<Integer, Integer> curr = new Pair<Integer, Integer>(0, 0);

        while (!q.isEmpty()) {
            curr = q.remove();

            int x = curr.getKey();
            int y = curr.getValue();

            for (int[] dir : dirs) {
                // Neighbor cell coordinates.
                int nx = x + dir[0], ny = y + dir[1];

                // If the neighbor is within the matrix and is a farmland cell and not v yet.
                if (isWithinFarm(nx, ny, land.length, land[0].length) && !v[nx][ny]
                        && land[nx][ny] == 1) {
                    v[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        return curr;
    }

    public int[][] findFarmland(int[][] land) {
        boolean[][] v = new boolean[land.length][land[0].length];
        List<int[]> ans = new ArrayList<>();


        for (int x = 0; x < land.length; x++) {
            for (int y = 0; y < land[0].length; y++) {
                if (land[x][y] == 1 && !v[x][y]) {
                    Queue<Pair<Integer, Integer>> q = new LinkedList<>();

                    q.add(new Pair(x, y));
                    v[x][y] = true;

                    Pair<Integer, Integer> last = bfs(q, land, v);

                    int[] arr = new int[] {x, y, last.getKey(), last.getValue()};
                    ans.add(arr);
                }
            }
        }

        return ans.stream().toArray(int[][] :: new);
    }
}