class Solution {
    public String stringShift(String s, int[][] shift) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        int l = s.length();
        int rightShift = 0;
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                rightShift -= shift[i][1];
            } else {
                rightShift += shift[i][1];
            }
        }
        rightShift %= l;
        if (rightShift <= 0) {
            rightShift += l;
        }
        char[] array = s.toCharArray();
        swap(array, l - rightShift, l - 1);
        swap(array, 0, l - rightShift - 1);
        swap(array, 0 , l - 1);
        return new String(array);
    }
    
    private void swap(char[] array, int l, int r) {
        while (l < r) {
            char tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
            l++;
            r--;
        }
    }
}