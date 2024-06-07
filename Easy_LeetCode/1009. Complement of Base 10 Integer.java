class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int x = 1;
        while(x <= n){
             x = x << 1;  // equialently written as x*=2;
        }
        return n ^ (x-1);
    }
}

//-------------------------------
class Solution {
    public int bitwiseComplement(int n) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X - N;
    }
}