class Solution {
    public int stoneGameVII(int[] stones) {
        int N = stones.length;
        int[] dpCurr = new int[N], dpLast = new int[N];
        for (int i = N - 2; i >= 0; i--) {
            int total = stones[i];
            int[] temp = dpLast;
            dpLast = dpCurr;
            dpCurr = temp;
            for (int j = i + 1; j < N; j++) {
                total += stones[j];
                dpCurr[j] = Math.max(total - stones[i] - dpLast[j], total - stones[j] - dpCurr[j-1]);
            }
        }
        return dpCurr[N-1];
    }
}