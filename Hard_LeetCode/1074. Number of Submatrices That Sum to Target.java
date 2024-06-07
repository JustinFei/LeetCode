class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int res = 0;
        for (int i = 0; i < M; i++) {
            int[] cur = new int[N];
            for (int j = i; j < M; j++) {
                add(cur, matrix[j]);
                res += curNumber(cur, target);
            }
        }
        return res;
    }
    
    private void add(int[] cur, int[] row) {
        for (int i = 0; i < row.length; i++) {
            cur[i] += row[i];
        }
    }
    
    private int curNumber(int[] cur, int target) {
        int res = 0, sum;
        for (int i = 0; i < cur.length; i++) {
            sum = cur[i]; 
            if (sum == target) res++;
            for (int j = i + 1; j < cur.length; j++) {
                sum += cur[j];
                if (sum == target) res++;
            }
        }
        return res;
    }
}
//---------------------
public int numSubmatrixSumTarget(int[][] A, int target) {
        int res = 0, m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                A[i][j] += A[i][j - 1];
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                counter.clear();
                counter.put(0, 1);
                int cur = 0;
                for (int k = 0; k < m; k++) {
                    cur += A[k][j] - (i > 0 ? A[k][i - 1] : 0);
                    res += counter.getOrDefault(cur - target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }