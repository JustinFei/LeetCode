class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge: edges) {
            adj.computeIfAbsent(edge[0], value -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], value -> new ArrayList<Integer>()).add(edge[0]);
        }
        return dfs(0, -1, adj, hasApple);
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> adj,
            List<Boolean> hasApple) {
                if (!adj.containsKey(node)) {
                    return 0;
                }

                int totalTime = 0, childTime = 0;
                for (int child: adj.get(node)) {
                    if (child == parent) {
                        continue;
                    }
                    childTime = dfs(child, node, adj, hasApple);
                    // childTime > 0 indicates subtree of child has apples. Since the root node of the
            // subtree does not contribute to the time, even if it has an apple, we have to check it
            // independently.
                    if (childTime > 0 || hasApple.get(child)) {
                        totalTime += childTime + 2;
                    }
                }
                return totalTime;
            }
}