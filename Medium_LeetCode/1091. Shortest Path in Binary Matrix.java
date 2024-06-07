class Solution {
    private int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                if (p[0] == m - 1 && p[1] == n - 1) {
                    return res + 1;
                }
                for (int j = 0; j < 8; j++) {
                    int x = dir[j][0] + p[0];
                    int y = dir[j][1] + p[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}