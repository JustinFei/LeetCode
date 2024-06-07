class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] trip: trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]); 
        }
        
        int cnt = 0;
        for (int v: map.values()) {
            cnt += v;
            if (cnt > capacity) {
                return false;
            }
        }
        return true;
    }
}