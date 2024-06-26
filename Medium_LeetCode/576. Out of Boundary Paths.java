// Approach 1: Brute Force

class Solution {
  public int findPaths(int m, int n, int N, int i, int j) {
    if (i == m || j == n || i < 0 || j < 0) return 1;
    if (N == 0) return 0;
    return findPaths(m, n, N - 1, i - 1, j)
        + findPaths(m, n, N - 1, i + 1, j)
        + findPaths(m, n, N - 1, i, j - 1)
        + findPaths(m, n, N - 1, i, j + 1);
  }
}

// ---------------------------------

// 	Approach 2: Recursion with Memoization

class Solution {
  int M = 1000000007;

  public int findPaths(int m, int n, int N, int i, int j) {
    int[][][] memo = new int[m][n][N + 1];
    for (int[][] l : memo) for (int[] sl : l) Arrays.fill(sl, -1);
    return findPaths(m, n, N, i, j, memo);
  }

  public int findPaths(int m, int n, int N, int i, int j, int[][][] memo) {
    if (i == m || j == n || i < 0 || j < 0) return 1;
    if (N == 0) return 0;
    if (memo[i][j][N] >= 0) return memo[i][j][N];
    memo[i][j][N] = (
        (findPaths(m, n, N - 1, i - 1, j, memo) + findPaths(m, n, N - 1, i + 1, j, memo)) % M +
        (findPaths(m, n, N - 1, i, j - 1, memo) + findPaths(m, n, N - 1, i, j + 1, memo)) % M
    ) % M;
    return memo[i][j][N];
  }
}

// ---------------------------------------

// Approach 3: Dynamic Programming

public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;
        
        final int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int res = 0;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int move = 0; move < N; move++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            res = (res + dp[r][c]) % MOD;
                        }
                        else {
                            temp[nr][nc] = (temp[nr][nc] + dp[r][c]) % MOD;
                        }
                    }
                }
            }
            dp = temp;
        }
        
        return res;
    }
}