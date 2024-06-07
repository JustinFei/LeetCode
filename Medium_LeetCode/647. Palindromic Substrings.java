// Brute force  O(n3) O(1)

class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) return 0;

        int res = 0;
        for (int i = 0; i < s.length(); i++)
            for (int j = i; j < s.length(); j++)
                res += isPalindromic(s, i, j);
        return res;
    }

    private int isPalindromic(String s, int l, int r) {
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--))
                return 0;
        return 1;
    }
}

// Expand O(n2) O(1)

class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += countPalindromes(s, i, i); // Count even
            res += countPalindromes(s, i, i + 1); // Count odd
        }

        return res;
    }

    private int countPalindromes(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++))
            count++;
        return count;
    }
}

// dp O(n2) O(n2)

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) res++;
            }
        }

        return res;
    }
}