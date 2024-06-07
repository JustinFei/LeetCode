// BFS
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight: flights) {
            map.computeIfAbsent(flight[0], value -> new ArrayList<>()).add(new int[]{ flight[1], flight[2] });
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });
        int stops = 0;
        while (stops <= k && !q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curArray = q.poll();
                int cur = curArray[0];
                int curPrice = curArray[1];

                if (!map.containsKey(cur)) {
                    continue;
                }

                for (int[] nextArray: map.get(cur)) {
                    int next = nextArray[0];
                    int nextPrice = nextArray[1];

                    if (curPrice + nextPrice >= dist[next]) {
                        continue;
                    }
                    dist[next] = curPrice + nextPrice;
                    q.offer(new int[] { next, dist[next] });
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? - 1 : dist[dst];
    }
}

// ------------------------------------------------------------

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        for (int i = 0; i <= k; i++) {
            if (isRoutePossible(distance, flights)) {
                break;
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
    private boolean isRoutePossible(int[] dist, int[][] flights) {
        int[] copy = Arrays.copyOf(dist, dist.length);
        boolean result = true;

        for (int[] flight : flights) {
            int src = flight[0];
            int dst = flight[1];
            int  cost =flight[2];

            if (copy[src] < Integer.MAX_VALUE && dist[dst] > dist[src] + cost) {
                dist[dst] = cost + copy[src];
                result = false;
            }
        }
        return result;
    }
}

// DFS --------------------------------------------------------
class Solution {
    
    int minPathCost;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        minPathCost = Integer.MAX_VALUE; // initialize the minPathCost with Integer.MAX_VALUE
        Map<Integer, List<int[]>> graph = createGraph(flights); // create graph

        dfs(graph, src, dst, K + 1, 0); // K stop => K + 1 edges
        return minPathCost == Integer.MAX_VALUE ? -1 : minPathCost;
    }

    private void dfs(Map<Integer, List<int[]>> graph, int src, int dst, int k, int currentCost) {
        if (k < 0) return; // if covered k stops and not reached destination
        if (src == dst) { // if reached destination currentCost is minPathCost
            minPathCost = currentCost;
            return;
        }
        if (!graph.containsKey(src))
            return;
        for (int[] flight : graph.get(src)) {
            if (currentCost + flight[1] > minPathCost) // cost + current flight cost > minPathCost discard that path ~ pruning
                continue;
            dfs(graph, flight[0], dst, k - 1, currentCost + flight[1]);
        }
    }

    private Map<Integer, List<int[]>> createGraph(int[][] flights) {
        Map<Integer, List<int[]>> graph = new HashMap<>(); // direct stops + cost to reach that stop
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        return graph;
    }
}
