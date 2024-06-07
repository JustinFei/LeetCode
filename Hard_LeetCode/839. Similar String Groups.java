class Solution {
    private boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff == 0 || diff == 2;
    }

    private void bfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;
        while (!q.isEmpty()) {
            node = q.poll();
            if (!adj.containsKey(node)) {
                continue;
            }
            for (int neighbor : adj.get(node)) {
                if (!visit[neighbor]) {
                    visit[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }

    private void dfs(int node, Map<Integer, List<Integer>> adjMap, boolean[] visited) {
        visited[node] = true;
        if (!adjMap.containsKey(node)) {
            return;
        }

        for (int nei: adjMap.get(node)) {
            if (!visited[nei]) {
                dfs(nei, adjMap, visited);
            }
        }
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        boolean[] visited = new boolean[n];

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        // Form the required graph from the given strings array.
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    adjMap.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
                    adjMap.computeIfAbsent(j, k -> new ArrayList<Integer>()).add(i);
                }
            }
        }

        int count = 0;
        // Count the number of connected components.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjMap, visited);
                // bfs(i, adjMap, visited);
                count++;
            }
        }

        return count;
    }
}