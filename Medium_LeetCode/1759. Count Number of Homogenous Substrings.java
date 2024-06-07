class Solution {
    public int countHomogenous(String s) {
        int res = 0;
        int curStreak = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) == s.charAt(i)) {
                curStreak++;
            } else {
                curStreak = 1;
            }

            res = (res + curStreak) % mod;
        }

        return res;
    }
}