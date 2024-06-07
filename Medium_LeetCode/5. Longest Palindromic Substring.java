class Solution { // O(n3) O(1)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        for (int l = s.length(); l > 0; l--) {
            for (int start = 0; start <= s.length() - l; start++) {
                if (check(start, start + l, s)) {
                    return s.substring(start , start + l);
                }
            }
        }

        return "";
    }

    private boolean check(int l, int r, String s) {
        r--;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

// ________________________________

class Solution { // O(n2) O(n2)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = -1, right = -1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (left == -1 || right - left < j - i)) {
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right + 1);
    }
}

// --------------------------------

class Solution { O(n2) O(1)
    public String longestPalindrome(String s) {
        int l = 0, r = 0;
        int oddExpand, evenExpand, dist;
        for (int i = 0; i < s.length(); i++) {
            oddExpand = expand(i, i, s);
            if (oddExpand > r - l + 1) {
                dist = oddExpand / 2;
                l = i - dist;
                r = i + dist;
            }

            evenExpand = expand(i, i + 1, s);
            if (evenExpand > r - l + 1) {
                dist = evenExpand / 2 - 1;
                l = i - dist;
                r = i + dist + 1;
            }
        }

        return s.substring(l, r + 1);
    }

    private int expand(int l, int r, String s) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
