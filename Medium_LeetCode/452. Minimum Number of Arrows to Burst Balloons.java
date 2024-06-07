class Solution {
    public int findMinArrowShots(int[][] points) {
        int count = 0;
        long end = Long.MIN_VALUE;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        for (int[] p : points){
            if (p[0] > end) {
                end = p[1];
                count++;
            }
        }

        return count;
    }
}