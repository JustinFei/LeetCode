class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, res);
        return res;
    }
    
    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int nextNode: graph[node]) {
            path.add(nextNode);
            dfs(graph, nextNode, path, res);
            path.remove(path.size() - 1);
        }
    } 
}