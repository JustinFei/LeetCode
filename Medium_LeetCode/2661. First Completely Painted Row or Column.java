class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // int[][][] a = new int[m][n][2];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         int r = (mat[i][j] - 1) / n;
        //         int c = (mat[i][j] - 1) % n;
        //         a[r][c] = new int[]{i, j};
        //     }
        // }

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] r = new int[m];
        int[] c = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int[] cur = map.get(arr[i]);
            if (++r[cur[0]] == n || ++c[cur[1]] == m) return i;

        }

        return -1;
    }
}