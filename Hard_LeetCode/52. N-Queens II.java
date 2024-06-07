
class Solution {
    public int totalNQueens(int n) {
        int[] res = new int[]{0};
        List<Integer> cur = new ArrayList<>();
        helper(n, cur, res);
        return res[0];
    }
    
    private void helper(int n, List<Integer> cur, int[] res) {
        if (cur.size() == n) {
            res[0]++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(i, cur)) {
                cur.add(i);
                helper(n, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean isValid(int c, List<Integer> cur) {
        int row = cur.size();
        
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == c || Math.abs(c - cur.get(i)) == row - i) {
                return false;
            }
        }
        return true;
    }
}
//------------------------------------
class Solution {
    public boolean isNotUnderAttack(int row, int col, int n, int[] rows, int[] hills, int[] dales) {
        int res = rows[col] + hills[row + col] + dales[row - col + 2 * n];
        return (res == 0) ? true : false;
    }
    
    public int backTrack(int row, int count, int n, int[] rows, int[] hills, int[] dales) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col, n, rows, hills, dales)) {
                rows[col] = 1;
                hills[row + col] = 1;
                dales[row - col + 2 * n] = 1;
                
                if (row + 1 == n) {
                    count++;
                } else {
                    count = backTrack(row + 1, count, n, rows, hills, dales);
                }
                
                rows[col] = 0;
                hills[row + col] = 0;
                dales[row - col + 2 * n] = 0;
            }
        }
        return count;
    }
    
    public int totalNQueens(int n) {
        int[] rows = new int[n];
        int[] hills = new int[2 * n - 1];
        int[] dales = new int[4 * n - 1];
        return backTrack(0, 0, n, rows, hills, dales);
    }
}