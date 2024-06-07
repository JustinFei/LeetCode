class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new MyComparator());
        int end = intervals[0][1];
        int count = 1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
    
    class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] == b[1]) {
                return 0;
            }
            return 1;
        }
    }
}