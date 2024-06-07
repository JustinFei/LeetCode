public class Solution {
    public int numDistinct(String s, String t) {
        // should be some conner cases
        
        int[][] ds = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            ds[0][i] = 1;
        }
        
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    ds[i][j] = ds[i - 1][j - 1] + ds[i][j - 1];
                } else {
                    ds[i][j] = ds[i][j - 1];
                }
            }
        }
        return ds[t.length()][s.length()];
    }
}