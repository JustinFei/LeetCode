class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] r : roads) {
            map.put(r[0], map.getOrDefault(r[0], 0) + 1);
            map.put(r[1], map.getOrDefault(r[1], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> -Integer.compare(a[1], b[1]));
        int[] v = new int[n];
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(new int[] {entry.getKey(), entry.getValue()});
        }
        int i = n;
        long res = 0;
        while (!pq.isEmpty()) v[pq.poll()[0]] = i--;
        for (int[] r : roads) res += v[r[0]] + v[r[1]];

        return res;
    }
}


// ---------------------------------

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long res = 0, x = 1;
        long degree[] = new long[n];
        for(int road[] : roads){
            degree[road[0]]++; 
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        for(long d : degree) res +=  d * (x++) ;
        return res;
    }
}