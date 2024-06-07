class Solution {
    public static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int m = heights.length, n = heights[0].length;
         Integer[][] minDist = new Integer[m][n];
        
        minDist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] == m - 1 && cur[2] == n - 1) {
                return cur[0];
            }
            for (int[] dir : dirs) {
                int nr = cur[1] + dir[0];
                int nc = cur[2] + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                int effort = Math.max(cur[0], Math.abs(heights[cur[1]][cur[2]] - heights[nr][nc]));
                if (minDist[nr][nc] == null || minDist[nr][nc] > effort) {
                    minDist[nr][nc] = effort;
                    pq.offer(new int[]{minDist[nr][nc], nr, nc});
                }
            }
        }
        return -1;
    }
}