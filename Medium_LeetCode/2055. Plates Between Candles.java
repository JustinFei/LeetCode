class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int psum[] = new int[n + 1];
        int next[] = new int[n + 1], prev[] = new int[n + 1];

        Arrays.fill(next, Integer.MAX_VALUE);

        int res[] = new int[queries.length];

        for (int i = 0; i < n; i++) {
            psum[i + 1] = psum[i] + (s.charAt(i) == '|' ? 1 : 0);
            prev[i + 1] = s.charAt(i) == '|' ? i : prev[i];
        }

        for (int i = n - 1; i >= 0; i--)
            next[i] = s.charAt(i) == '|' ? i : next[i + 1];

        for (int j = 0; j < queries.length; j++) {
            int l = next[queries[j][0]], r = prev[queries[j][1] + 1];
            res[j] = l < r ? r - l - (psum[r] - psum[l]) : 0;
        }

        return res;
    }
}