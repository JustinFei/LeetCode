class Solution {
    public int minScore(int n, int[][] roads) {
        int res = Integer.MAX_VALUE;
        List<List<Pair<Integer, Integer>>> gr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<Pair<Integer, Integer>>());
        }

        for (int[] road: roads) {
            gr.get(road[0]).add(new Pair<>(road[1], road[2]));
            gr.get(road[1]).add(new Pair<>(road[0], road[2]));
        }

        int[] vis = new int[n+1];
        Arrays.fill(vis, 0);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Pair<Integer, Integer> pair: gr.get(node)) {
                int v = pair.getKey();
                int dis = pair.getValue();
                res = Math.min(res, dis);
                if(vis[v]==0) {
                    vis[v] = 1;
                    q.add(v);
                }
            }
        }

        return res;
    } 
}