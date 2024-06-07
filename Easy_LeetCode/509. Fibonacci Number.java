class Solution {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }
        
        int a = 0;
        int b = 1;
        int tmp = 0;
        while (N > 1) {
            tmp = a + b;
            a = b;
            b = tmp;
            N--;
        }
        return tmp;
    }
}