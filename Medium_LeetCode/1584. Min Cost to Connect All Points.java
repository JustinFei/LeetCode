class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int res = 0, connected = 0, i = 0, n = points.length;
        boolean[] visited = new boolean[n];
        while (++connected < n) {
            visited[i] = true;
            for (int j = 1; j < n; j++) {
                if (!visited[j]) {
                    pq.offer(new int[]{Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]),j});
                }
            }
            while (visited[pq.peek()[1]]) {
                pq.poll();                
            }
            int[] cur = pq.poll();
            res += cur[0];
            i = cur[1];
        }
        return res;
    }
}