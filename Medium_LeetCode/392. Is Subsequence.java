public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int iS = 0;
        int iT = 0;
        while (iT < t.length()) {
            if (s.charAt(iS) == t.charAt(iT)) {
                iS++;
                if (iS == s.length()) return true;
            }
            iT++;
        }
        return false;
    }
}