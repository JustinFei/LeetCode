class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build big double direction map
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        String start, end;
        for (int i = 0; i < equations.size(); i++) {
            start = equations.get(i).get(0);
            end = equations.get(i).get(1);
            map.computeIfAbsent(start, k -> new HashMap<String, Double>()).put(end, values[i]);
            map.computeIfAbsent(end, k -> new HashMap<String, Double>()).put(start, 1.0 / values[i]);
        }
        // deal with every query
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            start = queries.get(i).get(0);
            end = queries.get(i).get(1);
            // first check if start or end exist in big map or not
            if (!map.containsKey(start) || !map.containsKey(end)) {
                res[i] = -1.0;
                continue;
            }
            // enter dfs loop, for each query, there is a new visited set
            res[i] = dfs(map, start, end, new HashSet<>());
        }
        return res;
    }
    public double dfs(HashMap<String, HashMap<String, Double>> map, String start, String end, HashSet<String> visited) {
        // actually no need to check quitting condition, because if one can enter this dfs, one must iterate all children
        // if (!map.containsKey(start)) return -1;
        if (map.get(start).containsKey(end)) {
            return map.get(start).get(end);
        }
        // mark visited
        visited.add(start);
        for (Map.Entry<String, Double> entry : map.get(start).entrySet()) {
            if (visited.contains(entry.getKey())) continue;
            double res = dfs(map, entry.getKey(), end, visited);
            if (res == -1.0) continue;
            return res * entry.getValue();
        }
        return -1.0;
    }
}