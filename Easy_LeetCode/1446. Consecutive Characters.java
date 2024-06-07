class Solution {
    public int maxPower(String s) {
        // if (s == null || s.length() == 0) {
        //     return 0;
        // }
        int max = 1;
        int tmp = 1;
        char preChar = s.charAt(0);
        char tmpChar = preChar;
        for (int i = 1; i < s.length(); i++) {
            tmpChar = s.charAt(i);
            if (tmpChar == preChar) {
                tmp++;
                max = Math.max(max, tmp);
            } else {
                tmp = 1;
                preChar = tmpChar;
            }
        }
        return max;
    }
}