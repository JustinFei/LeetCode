class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int[] res = new int[M * N];
        findDiagonalOrder(matrix, 0, 0, 0, true, res);
        return res;
    }
    private void findDiagonalOrder(int[][] matrix, int i, int j, int k, boolean isUp, int[] res) {
        int M = matrix.length;
        int N = matrix[0].length;
        if (i < 0 || i >= M || j < 0 || j >= N) {
            return;
        }
        if (isUp) {
            while (i >= 0 && j < N) {
                res[k++] = matrix[i][j];
                i--;
                j++;
            }
            if (j >= N) {
                findDiagonalOrder(matrix, i + 2, N - 1, k, false, res);
            } else {
                findDiagonalOrder(matrix, 0, j, k, false, res);
            }
        } else {
            while (i < matrix.length && j >= 0) {
                res[k++] = matrix[i][j];
                i++;
                j--;
            }
            if (i >= M) {
                findDiagonalOrder(matrix, M - 1, j + 2, k, true, res);
            } else {
                findDiagonalOrder(matrix, i, 0, k, true, res);
            }
        }
    }
}