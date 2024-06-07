class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) 
            return 0;
        int res = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                chars[res++] = chars[start];
                if (i > start) {
                    for (char c: ("" + (i - start + 1)).toCharArray()) {
                       chars[res++] = c;
                    }
                }
                start = i + 1;
            }
        }
        return res;
    }
}