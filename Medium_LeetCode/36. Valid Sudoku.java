class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        Set<String> set = new HashSet<>();
        int number;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.') {
                    number = (int) board[i][j];
                    if (!set.add(number + "r" + i) || 
                        !set.add(number + "c"+ j) || 
                        !set.add(number +"in" + i / 3 + "-" + j / 3 )) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}