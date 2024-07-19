class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int[] row : matrix) {
            int min = row[0];
            for (int i = 1; i < row.length; i++) min = Math.min(min, row[i]);
            set.add(min);
        }

        for (int j = 0; j < matrix[0].length; j++) {
            int max = matrix[0][j];
            for (int i = 1; i < matrix.length; i++) max = Math.max(max, matrix[i][j]);
            if (set.contains(max)) res.add(max);
        }

        return res;
    }
}