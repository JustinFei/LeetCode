class Solution {
    public int reverse(int x) {
        boolean positive = true;
        if (x < 0) {
            positive = false;
            x = -x;
        }
        long result = 0;  // in case of overflow
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) return 0;
        return positive ? (int) result : -(int) result;
    }
}