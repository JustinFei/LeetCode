class Solution {
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        
        char[] c = S.toCharArray();
        int s = 0; 
        for (int i = 0; i < c.length; i++, s++) {
            c[s] = c[i];
            if (s > 0 && c[s - 1] == c[s]) {
                s -= 2;
            }
            
        }
        return  new String(c, 0, s);
    }
}