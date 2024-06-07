public class Solution {
    public int hammingDistance(int x, int y) {
        x ^= y;
        int count = 0;
        while (x > 0) {
            count += x & 1;
            x >>>= 1;
        }
        return count;
    }
}