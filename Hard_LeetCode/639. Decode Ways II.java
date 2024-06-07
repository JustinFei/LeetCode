class Solution { //  O(n) O(n). 
    int M = 1000000007;
    public int numDecodings(String s) {
        Long[] memo = new Long[s.length()];
        return (int) ways(s, s.length() - 1, memo);
    }
    
    private long ways(String s, int i, Long[] memo) {
        if (i < 0) {
            return 1;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        long res;
        if (s.charAt(i) == '*') {
            res = 9 * ways(s, i - 1, memo) % M;
            if (i > 0 && s.charAt(i - 1) == '1') {
                res = (res + 9 * ways(s, i - 2, memo)) % M;
            } 
            else if (i > 0 && s.charAt(i - 1) == '2') {
                res = (res + 6 * ways(s, i - 2, memo)) % M;
            }
            else if (i > 0 && s.charAt(i - 1) == '*') {
                res = (res + 15 * ways(s, i - 2, memo)) % M;
            } 
            memo[i] = res;
            return memo[i];
        }
        res = s.charAt(i) != '0' ? ways(s, i - 1, memo) : 0;
        if (i > 0 && s.charAt(i - 1) == '1') {
            res = (res + ways(s, i - 2, memo)) % M;
        } 
        else if (i > 0 && s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
            res = (res + ways(s, i - 2, memo)) % M;
        }
        else if (i > 0 && s.charAt(i - 1) == '*') {
            res = (res + (s.charAt(i) <= '6' ? 2: 1) * ways(s, i - 2, memo)) % M;
        } 
        memo[i] = res;
        return memo[i];
    }
}

//------------------------
public class Solution { //  O(n)  O(n). 
    int M = 1000000007;
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                dp[i + 1] = 9 * dp[i] % M;
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2')
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
            } else {
                dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
            }
        }
        return (int) dp[s.length()];
    }
}
//-------------------------
public class Solution { //  O(n)  O(1) 
    int M = 1000000007;
    public int numDecodings(String s) {
        long first = 1, second = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            long temp = second;
            if (s.charAt(i) == '*') {
                second = 9 * second % M;
                if (s.charAt(i - 1) == '1')
                    second = (second + 9 * first) % M;
                else if (s.charAt(i - 1) == '2')
                    second = (second + 6 * first) % M;
                else if (s.charAt(i - 1) == '*')
                    second = (second + 15 * first) % M;
            } else {
                second = s.charAt(i) != '0' ? second : 0;
                if (s.charAt(i - 1) == '1')
                    second = (second + first) % M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    second = (second + first) % M;
                else if (s.charAt(i - 1) == '*')
                    second = (second + (s.charAt(i) <= '6' ? 2 : 1) * first) % M;
            }
            first = temp;
        }
        return (int) second;
    }
}