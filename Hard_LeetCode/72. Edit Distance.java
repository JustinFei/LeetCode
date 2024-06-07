public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        else if (word1 == null || word1.length() == 0) return word2 == null ? 0 : word2.length();
        else if (word2 == null || word2.length() == 0) return word1 == null ? 0 : word1.length();
        int m = word1.length();
        int n = word2.length();
        
        int[][] array = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                     array[i][j] = j;
                } else if (j == 0) {
                    array[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j - 1];
                } else {
                   array[i][j] = Math.min(array[i - 1][j]  + 1, array[i][j - 1]  + 1);
                   array[i][j] = Math.min(array[i - 1][j - 1]  + 1, array[i][j]);
                }
            }
        }
        return array[m][n];
    }
}