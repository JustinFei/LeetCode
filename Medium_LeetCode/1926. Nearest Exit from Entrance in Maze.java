class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int size, x, y, res = 0;
        int[] cur;
        q.offer(entrance);
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;
        while (!q.isEmpty()) {
            size = q.size();
            res++;
            while (size > 0) {
                cur = q.poll();
                for (int[] dir : dirs) {
                    x = cur[0] + dir[0];
                    y = cur[1] + dir[1];
                    if (x < 0 || x >= m  || y < 0 || y >= n) continue;
                    if (maze[x][y] == '.' && visited[x][y] != true) {
                        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) return res;
                        q.offer(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
                size--;
            }   
        }
        return -1;
    }
}