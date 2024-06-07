class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1 || edges == null || edges.length == 0) {
            res.add(0);
            return res;
        };

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[n];
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<Integer>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<Integer>()).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (degree[i] == 1) 
                q.offer(i);

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                list.add(cur);
                for (int parent : map.get(cur)) {
                    degree[parent]--;
                    if (degree[parent]== 1) q.offer(parent);
                }
            }
            res = list;
        }

        return res;
    }
}