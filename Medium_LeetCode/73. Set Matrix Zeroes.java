class Solution { // O(n) Space
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < R; i++) {
          for (int j = 0; j < C; j++) {
            if (matrix[i][j] == 0) {
              rows.add(i);
              cols.add(j);
            }
          }
        }

        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < R; i++) {
          for (int j = 0; j < C; j++) {
            if (rows.contains(i) || cols.contains(j)) {
              matrix[i][j] = 0;
            }
          }
        }
      }
    
}

//------------------------------------------------------------------------
class Solution { // O(1) Space
    public void setZeroes(int[][] matrix) {
        int rownum = matrix.length;
        if (rownum == 0)  return;
        int colnum = matrix[0].length;
        if (colnum == 0)  return;

        boolean hasZeroFirstRow = false, hasZeroFirstColumn = false;

        // Does first row have zero?
        for (int j = 0; j < colnum; ++j) {
            if (matrix[0][j] == 0) {
                hasZeroFirstRow = true;
                break;
            }
        }

        // Does first column have zero?
        for (int i = 0; i < rownum; ++i) {
            if (matrix[i][0] == 0) {
                hasZeroFirstColumn = true;
                break;
            }
        }

        // find zeroes and store the info in first row and column
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set zeroes except the first row and column
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)  matrix[i][j] = 0;
            }
        }

        // set zeroes for first row and column if needed
        if (hasZeroFirstRow) {
            for (int j = 0; j < colnum; ++j) {
                matrix[0][j] = 0;
            }
        }
        if (hasZeroFirstColumn) {
            for (int i = 0; i < rownum; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}