class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int max = A[A.length - 1];
        int min = A[0];
        int res = max - min;

        for (int i = 0; i < A.length - 1; ++i) {
            int a = A[i], b = A[i+1];
            int high = Math.max(max - K, a + K);
            int low = Math.min(min + K, b - K);
            res = Math.min(res, high - low);
        }
        return res;
    }
}