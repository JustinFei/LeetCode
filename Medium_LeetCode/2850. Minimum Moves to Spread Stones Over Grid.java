class Solution {
    public int minimumMoves(int[][] grid) {
        dfs1(0, 0, grid);
        return maxNumber;
    }

    int maxNumber= Integer.MAX_VALUE;

    private void dfs1(int cur, int moves, int[][] grid) {
        if(moves > maxNumber) return;
        if(cur == 9){
            maxNumber = Math.min(maxNumber, moves);
            return;
        }
        int i = cur / 3;
        int j = cur % 3;

        if (grid[i][j] != 0) {
            dfs1(cur + 1, moves, grid);
            return;
        }

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if(grid[k][l] <= 1) continue;
                grid[k][l] -= 1;
                grid[i][j] += 1;
                dfs1(cur+1, moves + Math.abs(i - k) + Math.abs(j - l), grid);
                grid[k][l] += 1;
                grid[i][j] -= 1;
            }
        }
    }
}