class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null) {
            return;
        }
        dfs(board, 0);
    }
    
    private boolean dfs(char[][] board, int num) {
        if (num == 81) {
            return true;
        }
        int i = num / 9;
        int j = num % 9;
        if (board[i][j] != '.') {
            return dfs(board, num + 1);
        }
        
        boolean[] v = new boolean[10];
        valid(board, i, j, v);
        for (int k = 1; k <= 9; k++) {
            if (v[k]) {
                board[i][j] = (char)(k + '0');
                if (dfs(board, num + 1)) {
                    return true;
                }
            }
        }
        board[i][j] = '.';
        return false;
    }
    
    private void valid(char[][] board, int i, int j, boolean[] v) {
        Arrays.fill(v, true);
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '.') {
                v[board[i][k] - '0'] = false;
            }
            if (board[k][j] != '.') {
                v[board[k][j] - '0'] = false;
            }
            int r = i / 3 * 3 + k / 3;
            int c = j / 3 * 3 + k % 3;
            if (board[r][c] != '.') {
                v[board[r][c] - '0'] = false;
            }
        }
    }
}