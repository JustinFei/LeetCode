class Solution {
    public int longestMountain(int[] A) {
        int n = A.length;
        int res = 0;
        int left = 0;
        while (left < n) {
            int right = left;
            if (right + 1 < n && A[right] < A[right + 1]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    right++;
                }
                if (right + 1 < n && A[right] > A[right + 1]) {
                     while (right + 1 < n && A[right] > A[right + 1]) {
                        right++;
                    }
                    res = Math.max(res, right - left + 1);
                }
            }
            left = Math.max(right, left + 1);
        }
        return res;
    }
}