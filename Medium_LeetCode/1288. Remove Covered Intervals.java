class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0;
        int left = -1;
        int right = -1;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for (int[] v : intervals) {
            if (v[0] > left && v[1] > right) {
                left = v[0];
                res++;
            }
            right = Math.max(right, v[1]);
        }
        return res;
    }
}

//------------------------------
class Solution {
    public int removeCoveredIntervals(int[][] A) {
        int res = 0, right = 0;
        Arrays.sort(A, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int[] v : A) {
            if (v[1] > right) {
                ++res;
                right = v[1];
            }
        }
        return res;
    }
}