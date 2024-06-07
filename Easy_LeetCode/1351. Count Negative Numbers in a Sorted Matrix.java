class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid[0].length;
        int cur = n - 1;
        for (int[] row : grid) {
            while (cur >= 0 && row[cur] < 0) {
                cur--;
            }
            count += n - cur - 1; 
        }
        return count;
    }
}