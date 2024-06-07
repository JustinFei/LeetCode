class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        int[] cur, pre;
        for (int i = 1; i < points.length; i++) {
            cur = points[i];
            pre = points[i - 1];
            res += Math.max(Math.abs(cur[0] - pre[0]), Math.abs(cur[1] - pre[1]));
        }

        return res;
    }
}