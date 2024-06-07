class Solution {
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int i = 0 ; i <= word1.length(); i++) {
            int[] tmp = new int[word2.length() + 1];
            
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) {
                    tmp[j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    tmp[j] = dp[j - 1];
                } else {
                    tmp[j] = 1 + Math.min(tmp[j - 1], dp[j]);
                }
            }
            dp = tmp;
        }
        return dp[word2.length()];
    }
}

//------------------------------------------------------------------------

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return -1;
        else if (word1 == null || word1.length() == 0) return word2.length();
        else if (word2 == null || word2.length() == 0) return word1.length();
        
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] matrix = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
        }
        return l1 + l2 - 2 * matrix[l1][l2];
    }
}