class Solution {
    public int minOperations(String s) {
        int firstOne = 0;
        int firstZero = 0;
        int cur;
        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i) - '0';
            if (i % 2 == 0) {
                if (cur == 0) {
                    firstOne++;
                } else {
                    firstZero++;
                }
            } else {
                if (cur == 0) {
                    firstZero++;
                } else {
                    firstOne++;
                }
            }
        }
        return Math.min(firstOne, firstZero);
    }
}

// -------------------------------------------

class Solution {
    public int minOperations(String s) {
        int start0 = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    start0++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    start0++;
                }
            }
        }
        
        return Math.min(start0, s.length() - start0);
    }
}