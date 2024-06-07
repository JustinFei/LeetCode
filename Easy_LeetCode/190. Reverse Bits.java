public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse |= ((n >>> i) & 1) << (31 - i);
        }
        return reverse;
    }
}
----------------------------------------------
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) == 1) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }
}