class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // two types of rows if it can transform to a chessboard
                // e.g., if there's a row 01010011
                // then any other row must be either 01010011 or 10101100 (inverse)
                //
                // corollary: the 4 corners of any rectangle inside the board must be one of the following:
                // - 4 zeros
                // - 2 zeros 2 ones
                // - 4 ones
                //
                // checks the top left corner rectangle
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }

        // first row and column
        // sum, i.e. count of one's
        int rowSum = 0, colSum = 0;
        // count of misplaced element
        int rowMisplaced = 0, colMisplaced = 0;
        for (int i = 0; i < n; i++) {
            rowSum += board[0][i];
            colSum += board[i][0];

            // if the final pattern is "1010..."
            if (board[i][0] == i % 2) {
                rowMisplaced++;
            }
            if (board[0][i] == i % 2) {
                colMisplaced++ ;
            }
        }

        // - if n == 2 * k, then count(0) == count(1) == k
        // - if n == 2 * k + 1, then count(0) == k, count(1) == k + 1
        //   or count(0) == k + 1, count(1) == k
        //
        // checking the first row and column is sufficient,
        // because the top left corner rectangle is verified
        if (rowSum != n / 2 && rowSum != (n + 1) / 2) {
            return -1;
        }
        if (colSum != n / 2 && colSum != (n + 1) / 2) {
            return -1;
        }

        if (n % 2 == 1) {
            // when n is odd
            // only one final pattern is possible
            //
            // if misplaced is even
            // then the final pattern is "1010..."
            //
            // if misplaced is odd,
            // then the final pattern is the inverse of "1010..."
            // i.e. "0101..."
            // and the actual count of misplaced elements is (n - misplace)
            //
            // e.g. "001", misplaced == 1
            // the final pattern should be "010",
            // and the actual count of misplaced elements is 2 == n - misplaced
            //
            // in either case, the actual count of misplaced elements is even
            if (colMisplaced % 2 == 1) {
                colMisplaced = n - colMisplaced;
            }
            if (rowMisplaced % 2 == 1) {
                rowMisplaced = n - rowMisplaced;
            }
        } else {
            // when n is even
            // the final pattern can be either "1010..." or "0101..."
            //
            // if the final pattern is "0101..." (inverse)
            // the misplaced counts for row and col will be
            // (n - rowMisplaced) and (n - colMisplaced) respectively
            //
            // misplaced and (n - misplaced) are both even
            // picks the minimum of them
            colMisplaced = Math.min(n - colMisplaced, colMisplaced);
            rowMisplaced = Math.min(n - rowMisplaced, rowMisplaced);
        }

        // one swap fixes two misplaced elements
        return (colMisplaced + rowMisplaced) / 2;
    }
}