class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k %= m * n;
        reverse(grid, 0, m * n - 1);
        reverse(grid, 0, k - 1);
        reverse(grid, k, m * n - 1);
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] row : grid)
            ans.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
        return ans;
    }
    private void reverse(int[][] g, int lo, int hi) {
        int m = g.length, n = g[0].length;
        while (lo < hi) {
            int r = lo / n, c = lo++ % n, i = hi / n, j = hi-- % n, 
            tmp = g[r][c];
            g[r][c] = g[i][j];
            g[i][j] = tmp;
        }
    }
}
//-----------------------------------------------------------------------
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length; 
        int start = m * n - k % (m * n);
        LinkedList<List<Integer>> ans = new LinkedList<>();
        for (int i = start; i < m * n + start; ++i) {
            int j = i % (m * n), r = j / n, c = j % n;
            if ((i - start) % n == 0)
                ans.add(new ArrayList<>());
            ans.peekLast().add(grid[r][c]);
        }
        return ans;
    }
}