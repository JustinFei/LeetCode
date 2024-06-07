class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
             return Integer.MAX_VALUE;
        }
        int sign = (dividend > 0) == (divisor > 0) ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res = 0;
        
        while (dividend - divisor >= 0) {
            int cur = divisor;
            int steps = 1; 
            while (dividend - (cur + cur) > 0) {
                cur = cur + cur;
                steps += steps;
            }
            res += steps;
            dividend = dividend - cur;
        }
        
        return res * sign;
    }
}
// -----------------------
class Solution {
     public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
}