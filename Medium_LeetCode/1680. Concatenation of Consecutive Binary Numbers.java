class Solution {
    public int concatenatedBinary(int n) {
        int mod = (int)(1e9 + 7);
        // int MOD = 1_000_000_007;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            int bitLen = (int)(Math.log(i) / Math.log(2)) + 1;
            res = ((res << bitLen) + i) % mod;
        }
        return (int)res;
        
        // long sum = 0;
        // for (int i = 1; i <= n; i++) {
        //     String binary = Integer.toBinaryString(i);
        //     sum = ((sum << binary.length()) + i) % 1000000007;
        // }
        // return (int) sum;
    }
}