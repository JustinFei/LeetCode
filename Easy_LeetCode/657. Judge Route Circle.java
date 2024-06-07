class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0)
            return true;
        int v = 0;
        int h = 0;
        char[] arr = moves.toCharArray();
        for (char c: arr) {
            switch(c) {
                case 'L':
                    h--;
                    break;
                case 'R':
                    h++;
                    break;
                case 'U':
                    v++;
                    break;
                case 'D':
                    v--;
                    break;
            }
        }
        return v == 0 & h == 0;
    }
}