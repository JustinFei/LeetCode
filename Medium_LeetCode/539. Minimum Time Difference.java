class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String timePoint: timePoints) {
            int h = Integer.parseInt(timePoint.substring(0, 2));
            int s = Integer.parseInt(timePoint.substring(3, 5));
            if (mark[h * 60 + s]) {
                return 0;
            }
            mark[h * 60 + s] = true;
        }

        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }

        min = Math.min(min, (24 * 60 - last + first));
        return min;
    }
}