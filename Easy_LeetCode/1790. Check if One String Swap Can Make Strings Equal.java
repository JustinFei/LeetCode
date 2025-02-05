class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        if (n == 1) 
            return s1.charAt(0) == s2.charAt(0) ? true : false;
        int n1 = -1, n2 = -1;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            if (n1 == -1) n1 = i;
            else if (n2 == -1) n2 = i;
            else return false;
        }

        if (n1 == -1) return true;
        if (n2 == -1) return false;
        return s1.charAt(n1) == s2.charAt(n2) && s1.charAt(n2) == s2.charAt(n1);
    }
}