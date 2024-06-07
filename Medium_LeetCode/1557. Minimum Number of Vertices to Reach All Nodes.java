class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // List to signify if the vertex has an incoming edge or not.
        boolean[] seen = new boolean[n];
        for (List<Integer> edge : edges) {
        seen[edge.get(1)] = true;
        }

        List<Integer> res = new ArrayList();
        for (int i = 0; i < n; i++) {
            // Store all the nodes that don't have an incoming edge.
            if (!seen[i]) {
                res.add(i);
            }
        }

        return res;
    }
}