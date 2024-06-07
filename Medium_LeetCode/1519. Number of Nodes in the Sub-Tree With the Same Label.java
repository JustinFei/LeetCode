class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge: edges) {
            adj.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        int[] ans = new int[n];
        dfs(0, -1, labels, adj, ans);
        return ans;
    }

    private int[] dfs(int node, int parent, String labels, Map<Integer, List<Integer>> adj, int[] ans) {
        int[] cnt = new int[26];
        char label = labels.charAt(node);
        cnt[label - 'a'] = 1;
        for (int child: adj.getOrDefault(node, Collections.emptyList())) {
            if (child != parent) {
                int[] sub = dfs(child, node, labels, adj, ans);
                for (int i = 0; i < 26; i++) {
                    cnt[i] += sub[i];
                }
            }
        }
        ans[node] = cnt[label - 'a'];
        return cnt;
    }
}