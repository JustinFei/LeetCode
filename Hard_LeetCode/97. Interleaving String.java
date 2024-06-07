class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        boolean[][] canMerge = new boolean[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 && j == 0) {
                    canMerge[i][j] = true;
                }
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    canMerge[i][j] |= canMerge[i - 1][j];
                }
                
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    canMerge[i][j] |= canMerge[i][j - 1];
                }
            }
        }
        return canMerge[l1][l2];
    }
}