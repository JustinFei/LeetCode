class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] arrival = new double[dist.length];

        for (int i = 0; i < dist.length; i++) {
            arrival[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(arrival);
        
        for (int i = 0; i < dist.length; i++) {
            if (arrival[i] <= i) return i;
        }
        return dist.length;
    }
}
