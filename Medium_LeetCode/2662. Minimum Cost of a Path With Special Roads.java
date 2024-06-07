class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        queue.offer(new int[] {start[0], start[1], 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0], y = cur[1], cost = cur[2];
            Pair pos = new Pair(x, y);

            if (visited.contains(pos)) continue;

            if (x == target[0] && y == target[1]) {
                return cost; 
            }

            visited.add(pos);

            queue.offer(new int[] {target[0], target[1], cost + Math.abs(target[0] - x) + Math.abs(target[1] - y)});

            for (int[] road : specialRoads)
                if (!visited.contains(new Pair(road[2], road[3])))
                    queue.offer(new int[] {road[2], road[3], Math.abs(road[0] - x) + Math.abs(road[1] - y) + cost + road[4]});
        }

        return -1;
    }
}