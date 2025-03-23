class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], t = road[2];
            g.get(u).add(new int[]{v, t});
            g.get(v).add(new int[]{u, t});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        int MOD = 1_000_000_007;

        while(!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int node = (int) cur[1];

            if (d > dist[node]) continue;

            for (int[] neighbor : g.get(node)) {
                int nextNode = neighbor[0];
                int dd = neighbor[1];

                if (dist[node] + dd < dist[nextNode]) {
                    dist[nextNode] = dist[node] + dd;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{dist[nextNode], nextNode});
                } else if (dist[node] + dd == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}