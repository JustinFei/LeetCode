public class Solution {
    public String reverseString(String s) {
         return new StringBuffer(s).reverse().toString();
    }
}


class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        char c;
        while (l < r) {
            c = s[l];
            s[l++] = s[r];
            s[r--] = c;
        }
    }
}