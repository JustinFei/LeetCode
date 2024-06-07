public class Solution {
public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] setXX = new HashSet[9];
        Set<Character>[] setYY = new HashSet[9];
        Set<Character>[] setXY = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            setXX[i] = new HashSet<>();
            setYY[i] = new HashSet<>();
            setXY[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if(!setXX[i].add(board[i][j])){
                    return false;
                }
                if(!setYY[j].add(board[i][j])){
                    return false;
                }
                if(!setXY[(j / 3)* 3 + i / 3].add(board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

}
------------------------------
public boolean isValidSudoku(char[][] board) {
    for(int i=0; i<=8; i++) {
        for(int j=0; j<=8; j++) {
            if(!isValid(board, 0, j, 8, j) || !isValid(board, i, 0, i, 8)) return false;
            if(i%3==0 && j%3==0 && !isValid(board, i, j, i+2, j+2)) return false;
        }
    }
    return true;
}
private boolean isValid(char[][] board, int starti, int startj, int endi, int endj) {
    int[] digits = new int[9];
    for(int i=starti; i<=endi; i++) {
        for(int j=startj; j<=endj; j++) {
            if(board[i][j]!='.' && ++digits[board[i][j]-'1']>1) return false;
        }
    }
    return true;
}
---------------------------------------
public boolean isValidSudoku(char[][] board) {
        //first dimension 0/horizontal 1/vertical 2/square
        //second dimension 0-8 represents the ith row/column/square
        //third dimension represents the occurrence of number 1-9
        boolean[][][] occur = new boolean[3][9][9];
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                if (occur[0][i][num]) return false;
                else occur[0][i][num] = true;
                if (occur[1][j][num]) return false;
                else occur[1][j][num] = true;
                int s = (i / 3) * 3 + j / 3;
                if (occur[2][s][num]) return false;
                else occur[2][s][num] = true;
            }
        }
        return true;
    }