class Solution {
    public int getLucky(String s, int k) {
        int cur = 0;
        for (char c : s.toCharArray()) {
            int p = c - 'a' + 1;
            while (p > 0) {
                cur += p % 10;
                p /= 10;
            }
        }

        while (--k > 0) {
            int d = 0;
            while (cur > 0) {
                d += cur % 10;
                cur /= 10;
            }
            cur = d;
        }

        return cur;
    }
}