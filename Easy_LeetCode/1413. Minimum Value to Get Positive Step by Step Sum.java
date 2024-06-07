class Solution {
    public int minStartValue(int[] nums) {
        int cur = 0, res = 0;
        for (int n: nums) {
            cur += n;
            res = Math.min(cur, res);
        }
        return -res + 1;
    }
}