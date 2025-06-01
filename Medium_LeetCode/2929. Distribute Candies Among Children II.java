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

// -----------------------------------

class Solution {

    public long distributeCandies(int n, int limit) {
        long ans = 0;
        for (int i = Math.max(0, n - limit * 2); i <= Math.min(limit, n); i++) {
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return ans;
    }
}

// ---------------------------------

class Solution {

    public long distributeCandies(int n, int limit) {
        return (
            cal(n + 2) -
            3 * cal(n - limit + 1) +
            3 * cal(n - (limit + 1) * 2 + 2) -
            cal(n - 3 * (limit + 1) + 2)
        );
    }

    public long cal(int x) {
        if (x < 0) {
            return 0;
        }
        return ((long) x * (x - 1)) / 2;
    }
}