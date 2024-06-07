class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
         if(fresh == 0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir: dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1]; 
                    if (x < 0 ||x >= rows || y < 0 || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    fresh--;
                }
            }
        }
        return fresh == 0? res - 1: -1;
    }
}