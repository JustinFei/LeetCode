class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        //the concept here used is as same as the product of the array except self
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        long mod = 12345;
        long prefixProduct = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (int) (prefixProduct % mod);
                prefixProduct = (prefixProduct * grid[i][j]) % mod;
            }
        }
        long suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                res[i][j] = (int) ((res[i][j] * suffixProduct) % mod);
                suffixProduct = (suffixProduct * grid[i][j]) % mod;
            }
        }
        return res;
    }
}