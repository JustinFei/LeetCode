class Solution {
     public boolean hasAllCodes(String s, int k) {
        Set<String> seen = new HashSet<>();
         for (int i = 0; i <= s.length() - k && seen.size() < 1 << k; i++) {
             seen.add(s.substring(i, i + k));
         }
         return seen.size() == 1 << k;
    }
}
//----------Time Limit Exceeded-----------------------------------------------
  class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        if (!helper(new char[k], 0, s)) {
            return false;
        }
        
        return true;
    }
    
    private boolean helper(char[] ca, int idx, String s) {
        if (idx == ca.length) {
            if (!s.contains(new String(ca))) {
                return false;
            }
            return true;
        }
        ca[idx] = '0';
        if (!helper(ca, idx + 1, s)) {
            return false;
        }
        ca[idx] = '1';
        return helper(ca, idx + 1, s);
    }
}  