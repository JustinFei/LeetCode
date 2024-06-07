class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] in: intervals) {
            if (in[1] < newInterval[0]) {
                list.add(in);
            } else if (newInterval[1] < in[0]) {
                list.add(newInterval);
                newInterval = in;
            } else {
                newInterval[0] = Math.min(in[0], newInterval[0]);
                newInterval[1] = Math.max(in[1], newInterval[1]);
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}