class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length, res[] = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Integer c;
        for (int a : arr2) map.put(a, 0);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : arr1) {
            c = map.get(a);
            if (c == null) pq.offer(a);
            else map.put(a, c + 1);
        }

        int i = 0;
        for (int a : arr2) {
            c = map.get(a);
            for (int j = 0; j < c; j++) res[i++] = a;
        }
        int s = pq.size();
        for (int j = 0; j < s; j++) res[i++] = pq.poll();
        return res;
    }
}