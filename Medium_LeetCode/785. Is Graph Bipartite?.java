class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> v = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!BFS(graph, i, v)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean BFS(int[][] graph, int index,  Map<Integer, Integer> v) {
        if (v.containsKey(index)) {
            return true;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(index);
        v.put(index, 0);
        while (!queue.isEmpty()) {
            int curIndex = queue.poll();
            int curGroup = v.get(curIndex);
            int neiGroup = curGroup == 0 ? 1 : 0;
            for (int nei : graph[curIndex]) {
                if (!v.containsKey(nei)) {
                    v.put(nei, neiGroup);
                    queue.offer(nei);
                } else if (v.get(nei) != neiGroup){
                    return false;
                }
            }
        }
        return true;
    }
}