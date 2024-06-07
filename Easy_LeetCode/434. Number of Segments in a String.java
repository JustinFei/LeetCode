public class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) cnt++;
        }
        return cnt;
    }
}