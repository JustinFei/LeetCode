public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration <= 0) return 0;
        int res = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            res += (timeSeries[i - 1] + duration) > timeSeries[i] ? timeSeries[i] - timeSeries[i - 1] : duration;
        }
        res += duration;
        return res;
    }
}