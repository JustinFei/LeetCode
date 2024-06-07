public class Solution {
    public int countVowelPermutation(int n) {
        final int MOD = 1000000007;
        
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        
        for (int j = 1; j < n; j++) {
            long a_next = e;
            long e_next = (a + i) % MOD;
            long i_next = (a + e + o + u) % MOD;
            long o_next = (i + u) % MOD;
            long u_next = a;
            
            a = a_next;
            e = e_next;
            i = i_next;
            o = o_next;
            u = u_next;
        }
        
        return (int)((a + e + i + o + u) % MOD);
    }
}

// --------------------------------------

class Solution {
    public int countVowelPermutation(int n) {
        int MOD = (int) (1e9 + 7);
        long[][] dp = new long[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        /*
            0: a
            1: e
            2: i
            3: o
            4: u
         */
        for (int i = 1; i < n; i++) {
            dp[i+1][0] = (dp[i][4] + dp[i][1] + dp[i][2]) % MOD;
            dp[i+1][1] = (dp[i][0] + dp[i][2]) % MOD;
            dp[i+1][2] = (dp[i][3] + dp[i][1]) % MOD;
            dp[i+1][3] = (dp[i][2]) % MOD;
            dp[i+1][4] = (dp[i][2] + dp[i][3]) % MOD;
        }

        long ans = 0;
        for (int i = 0; i < 5; i++)
            ans = (ans + dp[n][i]) % MOD;
        return (int) ans;
    }
}