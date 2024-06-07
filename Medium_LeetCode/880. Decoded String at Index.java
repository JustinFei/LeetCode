class Solution {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();
        
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                size *= S.charAt(i) - '0';
            } else {
                size++;
            }
        }
        
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }
            
            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size--;
            }
        }
        return "";
    }
}