class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char c;
        int cmin = 0, cmax = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') {
                cmin++;
                cmax++;
            } else if (c == ')') {
                cmax--;
                cmin = (cmin == 0) ? 0 : cmin - 1;
            } else {
                cmax++;
                cmin = (cmin == 0) ? 0 : cmin - 1;
            }
             if (cmax < 0) {
                return false;
            }
        }

        return cmin == 0;
    }
}