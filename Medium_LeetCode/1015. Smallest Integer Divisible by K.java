class Solution {
    public int smallestRepunitDivByK(int K) {
        int res = 0;
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }

        for (int i = 0; i < K; i++){ // TC:O(K)
            res = (res * 10 + 1) % K;
            if (res == 0){
                return i + 1;
            }
        }
        return -1;
    }
}