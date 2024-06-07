class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        Arrays.sort(arr);
        int N = arr.length;
        long[] dp = new long[N];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            map.put(arr[i], i);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (map.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[map.get(right)]) % MOD;
                    }
                } 
            }
        }
        long ans = 0;
        for (long n: dp) {
            ans += n;
        }
        return (int) (ans % MOD);
    }
}

//-------------------------------------------------
class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        long res = 0L, mod = (long)1e9 + 7;
        Arrays.sort(A);
        HashMap<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            dp.put(A[i], 1L);
            for (int j = 0; j < i; ++j)
                if (A[i] % A[j] == 0)
                    dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.getOrDefault(A[i] / A[j], 0L)) % mod);
            res = (res + dp.get(A[i])) % mod;
        }
        return (int) res;
    }
}