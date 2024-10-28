class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];
        char[] str = s.toCharArray();

        int cnt = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (str[i] - str[i - 1] - 1) % 26 == 0) {
                cnt++;
            } else {
                cnt = 1;
            }

            dp[str[i] - 'a'] = Math.max(dp[str[i] - 'a'], cnt);
        }

        for (int i = 0; i < 26; i++){
            ans += dp[i];
        }

        return ans;
    }
}

// -------------------------------------------------

class Solution {
    public int findSubstringInWraproundString(String p) {
        // count[i] is the maximum unique substring end with ith letter.
        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
        int[] count = new int[26];
        
        // store longest contiguous substring ends at current position.
        int maxLengthCur = 0; 

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLengthCur++;
            }
            else {
                maxLengthCur = 1;
            }
            
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);
        }
        
        // Sum to get result
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }
}