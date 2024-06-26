class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m, col = n;
        
        for(int[] op : ops) {
            row = Math.min(row, op[0]);
            col = Math.min(col, op[1]);
        }
        
        return row * col;
    }
}