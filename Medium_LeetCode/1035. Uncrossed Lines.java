class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

// ------------------------------------------------------------
// 1D
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2  = nums2.length;
        if (n1 < n2) return maxUncrossedLines(nums2, nums1);

        int[] dp = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0, pre = 0, cur; j < n2; j++) {
                cur = dp[j + 1];
                if (nums1[i] == nums2[j]) {
                    dp[j + 1] = 1 + pre;
                } else {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j]);
                }
                pre = cur;
            }
        }
        return dp[n2];
    }
}