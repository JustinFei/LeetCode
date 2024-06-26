class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix[0].length;
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = m - 1;
        while (up < down && left < right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; i>= left; i--) {
                res.add(matrix[down][i]);
            }
            for (int i = down - 1; i>= up + 1; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        if (left > right || up > down) {
            return res;
        }
        
        if (left == right) {
            for (int i = up; i<= down; i++) {
                res.add(matrix[i][left]);
            }
        } else {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
        }
        return res;
    }
}