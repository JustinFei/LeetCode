class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = s.charAt(i - 1) - '0';
            int second = (s.charAt(i - 2) - '0') * 10  + first;
            if (first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
// ---------------------
class Solution { // My answer. Time Limit Exceeded.
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int[] res = new int[]{0};
        if (array[0] == '0') {
            return 0;
        }
        
        numDecodings(array, 0, res);
        
        return res[0];
    }
    
    private void numDecodings(char[] array, int index, int[] res) {
        if (index == array.length) {
            res[0]++;
            return;
        }
        if ((index < array.length - 1 && array[index + 1] != '0') || index == array.length - 1) {
            numDecodings(array, index + 1, res);
        }
        if (index < array.length - 1) {
            if ((array[index] - '0') * 10 + (array[index + 1] - '0') <= 26) {
                if (index < array.length - 2 && array[index + 2] == '0') {
                    return;
                }
                numDecodings(array, index + 2, res);
            }
        }
    }
}

//---------------------------------
// Another good answer. Time Limit Exceeded. I think this question is focus you to use DP
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return numDecodings(0, s);
    }
    
    private int numDecodings(int index, String s) {
        int n = s.length();
        if (index == n) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        int res = numDecodings(index + 1, s);
        if (index < n - 1 && (s.charAt(index) == '1'||s.charAt(index) == '2' && s.charAt(index + 1) < '7')) {
            res += numDecodings(index + 2, s);
        }
        return res;
    }
}