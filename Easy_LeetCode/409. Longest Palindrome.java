class Solution {
    public int longestPalindrome(String s) {
        int res = 0, a[] = new int[58];
        for (char c : s.toCharArray()) a[c - 'A']++;
        boolean f = false;
        for (int n : a) {
            if (!f && n % 2 != 0) {
                f = true;
                res++;
                n--;
            }
            res += n % 2 == 0 ? n : n - 1;
        }
        return res;
    }
}