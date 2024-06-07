class Solution { // O (N * (2 ^ N))
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, res, new ArrayList<String>(), s);
        return res;
    }
    
    private void dfs(int start, List<List<String>> res, List<String> cur, String s) {
        if (start >= s.length()) {
            res.add(new ArrayList<String>(cur));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(start, end, s)) {
                cur.add(s.substring(start, end + 1));
                dfs(end + 1, res, cur, s);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}

// ----------------------------
class Solution {  // O (N * (2 ^ N))  O (N ^ 2)
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> res = new ArrayList<>();
        dfs(0, res, new ArrayList<String>(), s, dp);
        return res;
    }
    
    private void dfs(int start, List<List<String>> res, List<String> cur, String s, boolean[][] dp) {
        if (start >= s.length()) {
            res.add(new ArrayList<String>(cur));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                cur.add(s.substring(start, end + 1));
                dfs(end + 1, res, cur, s, dp);
                cur.remove(cur.size() - 1);
            }
        }
    }
}