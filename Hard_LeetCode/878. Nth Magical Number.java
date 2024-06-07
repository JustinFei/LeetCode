class Solution {
    /*
        Get gcd (greatest common divisor) and lcm (least common multiple) of (A, B).
        (a, b) = (A, B) while b > 0: (a, b) = (b, a % b)
        then, gcd = a and lcm = A * B / a

        How many magic numbers <= x ?
        By inclusion exclusion principle, we have:
        x / A + x / B - x / lcm

        Set our binary search range
        Lower bound is min(A, B), I just set left = 2.
        Upper bound is N * min(A, B), I just set right = 10 ^ 14.

        binary search, find the smallest x that x / A + x / B - x / lcm = N
    */
    public int nthMagicalNumber(int N, int A, int B) {
        // int MOD = 1_000_000_007;
        long a = A, b = B, tmp, l = 0, r = (long) N * Math.min(A, B), mod = (long)1e9 + 7;
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        while (l < r) {
            long m = l + (r - l) / 2;
            if (m / A + m / B - m / (A * B / a) < N) {
                l = m + 1;
            }
            else r = m;
        }
        return (int)(l % mod);
    }
}