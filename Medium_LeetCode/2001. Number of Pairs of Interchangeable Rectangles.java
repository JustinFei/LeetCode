class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long res = 0;
        var map = new HashMap<String, Integer>();
        for (var rect : rectangles) {
            int gcd = gcd(rect[0], rect[1]);
            int x = rect[0] / gcd, y = rect[1] / gcd;
            String ratio = x + "@" + y;
            map.merge(ratio, 1, Integer::sum);
        }

        for (var n : map.values()) res += n * (n - 1L) / 2;
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}