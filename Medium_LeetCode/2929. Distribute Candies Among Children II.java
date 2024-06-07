class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0;
        if (limit * 3 < n) return res;
        else if (limit * 3 == n) return (long) 1;
        int firstMin = Math.max(0, n - limit * 2);
        int firstMax = Math.min(limit, n);
        int secondMin, secondMax;

        for (int i = firstMin; i <= firstMax; i++) {
            secondMin = Math.max(0, n - limit - i);
            secondMax = Math.min(limit, n - i);
            res += secondMax - secondMin + 1;
        }

        return res;
    }
}