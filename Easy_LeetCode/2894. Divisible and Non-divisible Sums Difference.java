class Solution {
    public int differenceOfSums(int n, int m) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0) res += i;
            else res -= i;
        }
        return res;
    }
}

// ----------------------

class Solution {

    public int differenceOfSums(int n, int m) {
        int k = n / m;
        return (n * (n + 1)) / 2 - k * (k + 1) * m;
    }
}