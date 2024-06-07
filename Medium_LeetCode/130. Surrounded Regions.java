class Solution {
    public void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        
        int r = board.length;
        int c = board[0].length;
        
        boolean[][] visited = new boolean[r][c];
        
        //first and last row
        for (int j=0; j < c; j++) {
            dfs(board, 0, j, r, c, visited);
            dfs(board, r - 1, j, r, c, visited);
        }
        
        //first and last column
        for (int i=0; i < r; i++) {
            dfs(board, i, 0, r, c, visited);
            dfs(board, i, c - 1, r, c, visited);
        }
        
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        
        
    }
    
    private void dfs(char[][] board, int i, int j, int r, int c, boolean[][] visited) {
        if (i < 0 || i >= r) {
            return;
        }
        
        if (j < 0 || j >= c) {
            return;
        }
        
        if (board[i][j] == 'X' || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        
        dfs(board, i+1, j, r, c, visited);
        dfs(board, i-1, j, r, c, visited);
        dfs(board, i, j+1, r, c, visited);
        dfs(board, i, j-1, r, c, visited);
    }
}