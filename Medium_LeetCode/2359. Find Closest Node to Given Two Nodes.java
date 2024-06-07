class Solution {
    private void bfs(int startNode, int[] edges, int[] dist) {
        int n = edges.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);

        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, Boolean.FALSE);
        dist[startNode] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (visited[cur]) {
                continue;
            }

            visited[cur] = true;
            int neighbor = edges[cur];
            if (neighbor != -1 && !visited[neighbor]) {
                dist[neighbor] = dist[cur] + 1;
                q.offer(neighbor);
            }
        }

    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n], dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        bfs(node1, edges, dist1);
        bfs(node2, edges, dist2);

        int minDistNode = -1, minDistTillNow = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (minDistTillNow > Math.max(dist1[i], dist2[i])) {
                minDistNode = i;
                minDistTillNow = Math.max(dist1[i], dist2[i]);
            }
        }

        return minDistNode;
    }
}